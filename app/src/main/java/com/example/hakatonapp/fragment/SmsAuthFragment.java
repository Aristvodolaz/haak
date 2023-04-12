package com.example.hakatonapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hakatonapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SmsAuthFragment extends Fragment {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hakaton-502f4-default-rtdb.firebaseio.com/");

    FirebaseAuth auth;
    private EditText inputCode1, inputCode2, inputCode3, inputCode4, inputCode5, inputCode6;
    private String verificationId;
    public static SmsAuthFragment  newInstance(){
        return new SmsAuthFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sms_auth, container, false);

        TextView textPhone = view.findViewById(R.id.textPhone);

        auth = FirebaseAuth.getInstance();

        final ProgressBar progressBar = view.findViewById(R.id.progressBar);
        final Button loginBtn = view.findViewById(R.id.btn_log);

       loginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String code = inputCode1.getText().toString() + inputCode2.getText().toString() +
                       inputCode3.getText().toString() + inputCode4.getText().toString() +
                       inputCode5.getText().toString() + inputCode6.getText().toString();

               if(inputCode1.getText().toString().trim().isEmpty() ||
                       inputCode2.getText().toString().trim().isEmpty() ||
                       inputCode3.getText().toString().trim().isEmpty() ||
                       inputCode4.getText().toString().trim().isEmpty() ||
                       inputCode5.getText().toString().trim().isEmpty() ||
                       inputCode6.getText().toString().trim().isEmpty()){
                   Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                   return;
               } else{
                   progressBar.setVisibility(View.VISIBLE);
                   loginBtn.setVisibility(View.INVISIBLE);

                   //TODO фрагмент куда перекидывает после входа
                   replaceFragment(AuthFragment.newInstance(), true);
               }

           }
       });

        return view;
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