package com.example.hakatonapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hakatonapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegFrgament extends Fragment{

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().
            getReferenceFromUrl("https://hakaton-502f4-default-rtdb.firebaseio.com/");

    public RegFrgament(){
        super(R.layout.reg_layout);
    }

    public static Fragment newInstance() {
        return new RegFrgament();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        final EditText firstName = view.findViewById(R.id.name_user);
        final EditText surname = view.findViewById(R.id.surname_user);
        final EditText ageUser = view.findViewById(R.id.age_user);
        final EditText cityUser = view.findViewById(R.id.city_user);
        final EditText phoneUser = view.findViewById(R.id.phone_user);
        final EditText emailUser = view.findViewById(R.id.email_user);
        final EditText passwordU = view.findViewById(R.id.password_user);
        final EditText confPasswordU = view.findViewById(R.id.conf_password_user);
        final Button registerBtn = view.findViewById(R.id.regBtn);
        final TextView loginNowBtn = view.findViewById(R.id.loginNowBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstNameTxt = firstName.getText().toString();
                final String surnameTxt = surname.getText().toString();
                final String ageTxt = ageUser.getText().toString();
                final String cityTxt = cityUser.getText().toString();
                final String phoneTxt = phoneUser.getText().toString();
                final String emailTxt = emailUser.getText().toString();
                final String passwordTxt = passwordU.getText().toString();
                final String confPasswordTxt = confPasswordU.getText().toString();


                if(firstNameTxt.isEmpty() || surnameTxt.isEmpty() ||
                        ageTxt.isEmpty() || cityTxt.isEmpty() ||
                        phoneTxt.isEmpty() || emailTxt.isEmpty() ||
                        passwordTxt.isEmpty() || confPasswordTxt.isEmpty()){
                    Toast.makeText(getActivity(), "Заполните все поля!", Toast.LENGTH_SHORT).show();
                } else if(!passwordTxt.equals(confPasswordTxt)){
                    Toast.makeText(getActivity(), "Пароли не совпадают!",
                            Toast.LENGTH_SHORT).show();
                } else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(getActivity(), "Phone is already exist!",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                databaseReference.child("users").child(phoneTxt).
                                        child("firstName").setValue(firstNameTxt);
                                databaseReference.child("users").child(phoneTxt).
                                        child("surname").setValue(surnameTxt);
                                databaseReference.child("users").child(phoneTxt).
                                        child("age").setValue(ageTxt);
                                databaseReference.child("users").child(phoneTxt).
                                        child("city").setValue(cityTxt);
                                databaseReference.child("users").child(phoneTxt).
                                        child("email").setValue(emailTxt);
                                databaseReference.child("users").child(phoneTxt).
                                        child("password").setValue(passwordTxt);

                                Toast.makeText(getActivity(), "Пользователь успешно зарегистрирован!", Toast.LENGTH_SHORT).show();
                                //ToDO должно быть переключение дальше
                                getActivity().finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });
        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(AuthFragment.newInstance(), true);
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




//    private FirebaseFirestore firestore;
//    public static RegFrgament newInstance() {
//        return new RegFrgament();
//    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.reg_layout,container, false);
//
//        return view;
//    }