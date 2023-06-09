package com.example.hakatonapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hakatonapp.R;
import com.example.hakatonapp.fragment.AddDriverFragment;
import com.example.hakatonapp.fragment.AddPersonFragment;
import com.example.hakatonapp.fragment.MapsFragment;

public class CreateTravelActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_travel_main);

        if(getIntent().getBooleanExtra("wind", true) == true){
            replaceFragment(AddDriverFragment.newInstance(), true);
        } else replaceFragment(AddPersonFragment.newInstance(), true);


    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
