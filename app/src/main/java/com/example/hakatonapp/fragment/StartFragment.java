package com.example.hakatonapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hakatonapp.R;
import com.example.hakatonapp.activity.MainActivity;

public class StartFragment extends Fragment {
    FrameLayout container;
    public static StartFragment newInstance() {
        return new StartFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.start_layout, container,
                false);
        Button logBtn = view.findViewById(R.id.btn_log);
        Button signBtn = view.findViewById(R.id.btn_sign);
//        container = view.findViewById(R.id.auth);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(AuthFragment.newInstance(), true);
            }
        });
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(RegFrgament.newInstance(), true);
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
