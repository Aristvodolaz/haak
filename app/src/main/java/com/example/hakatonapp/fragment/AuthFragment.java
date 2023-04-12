package com.example.hakatonapp.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hakatonapp.R;
import com.example.hakatonapp.activity.InitActivity;
import com.example.hakatonapp.activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AuthFragment extends Fragment {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hakaton-502f4-default-rtdb.firebaseio.com/");

    public AuthFragment(){
        super(R.layout.auth_layout);
    }

    public static Fragment newInstance() {
        return new AuthFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        final EditText phone = view.findViewById(R.id.login_text);
        final EditText password = view.findViewById(R.id.pass_text);
        final Button loginBtn = view.findViewById(R.id.btn_log);
        final TextView regNowBtn = view.findViewById(R.id.regNowBtn);
        final TextView loginSms = view.findViewById(R.id.loginSms);
        final TextView forgPass = view.findViewById(R.id.forgPass);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(getActivity(), "Введите логин или пароль!",
                            Toast.LENGTH_SHORT).show();
                } else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneTxt)){
                                final String getPassword = snapshot.child(phoneTxt).
                                        child("password").getValue(String.class);

                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(getActivity(), "Successfully login!",
                                            Toast.LENGTH_SHORT).show();
                                    //ToDo: сделать куда будет перебрасывать после входа
                                    startActivity(new Intent(getActivity(),
                                            InitActivity.class));
                                    getActivity().finish();
                                }else{
                                    Toast.makeText(getActivity(), "Wrong password!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getActivity(), "Wrong password!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        regNowBtn.setOnClickListener(new View.OnClickListener() {

            //ToDo переключение на другую активность
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                replaceFragment(RegFrgament.newInstance(), true);
            }
        });

        loginSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(LoginBySmsFragment.newInstance(), true);
            }
        });

        forgPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(LoginBySmsFragment.newInstance(), true);
            }
        });
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

}
