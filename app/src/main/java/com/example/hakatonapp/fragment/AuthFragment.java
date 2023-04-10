package com.example.hakatonapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hakatonapp.R;
import com.example.hakatonapp.activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthFragment extends Fragment {


    EditText login_text, pass_text;
    Button btn_log;
    private FirebaseAuth auth;

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.auth_layout,container, false);
        login_text = view.findViewById(R.id.login_text);
        pass_text = view.findViewById(R.id.pass_text);
        btn_log = view.findViewById(R.id.btn_log);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth =FirebaseAuth.getInstance();
        FirebaseAuth.AuthStateListener mAuthListner = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                } else {
                }
            }
        };


        btn_log.setOnClickListener(v->{
            if(login_text.getText().toString()!=null && login_text.getText().toString().equals("")
                    && pass_text.getText().toString() != null && pass_text.getText().toString().equals(""))
            {
                auth.signInWithEmailAndPassword(login_text.getText().toString(), pass_text.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            Toast.makeText(getActivity(), "Good", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else Toast.makeText(getContext(), "Введите данные для авторизации!", Toast.LENGTH_LONG).show();

        });

//        auth.createUserWithEmailAndPassword().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(getActivity(), "Good", Toast.LENGTH_SHORT).show();
//                } else Toast.makeText(getActivity(), "Bad", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
