package com.example.hakatonapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hakatonapp.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegFrgament extends Fragment {

    private FirebaseFirestore firestore;
    public static RegFrgament newInstance() {
        return new RegFrgament();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.reg_layout,container, false);

        return v;
    }
}
