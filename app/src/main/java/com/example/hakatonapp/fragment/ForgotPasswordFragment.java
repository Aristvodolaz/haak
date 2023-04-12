package com.example.hakatonapp.fragment;

import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> origin/main
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

=======
>>>>>>> origin/main
import com.example.hakatonapp.R;

public class ForgotPasswordFragment extends Fragment {

    public ForgotPasswordFragment(){
        super(R.layout.fragment_forgot_password);
    }

    public static Fragment newInstance() {
        return new AuthFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText loginText = view.findViewById(R.id.login_text);
        final Button resetBtn = view.findViewById(R.id.btn_reset);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String loginTxt = loginText.getText().toString();

                if(loginTxt.isEmpty()){
                    Toast.makeText(getActivity(), "Введите логин", Toast.LENGTH_SHORT).show();
                } else {
                    
                }
            }
        });

    }
}