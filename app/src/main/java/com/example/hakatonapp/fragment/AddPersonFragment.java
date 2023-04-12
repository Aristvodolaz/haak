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

public class AddPersonFragment extends Fragment {
    public static AddPersonFragment newInstance() {
        return new AddPersonFragment();
    }
    private FirebaseFirestore db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =LayoutInflater.from(getContext()).inflate(R.layout.create_travel_driver, container, false);
        db = FirebaseFirestore.getInstance();


        return v;
    }
}
