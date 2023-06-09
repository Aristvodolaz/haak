package com.example.hakatonapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hakatonapp.R;
import com.example.hakatonapp.fragment.MapsFragment;
import com.example.hakatonapp.fragment.StartFragment;
import com.google.firebase.auth.FirebaseAuth;

public class InitActivity extends AppCompatActivity {

    FrameLayout container;
    ImageView driver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_main);
        container = findViewById(R.id.container);
        driver = findViewById(R.id.drivers);

        driver.setOnClickListener(v->{

        });
        replaceFragment(MapsFragment.newInstance(), true);

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
