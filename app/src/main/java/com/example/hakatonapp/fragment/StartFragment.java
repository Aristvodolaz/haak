package com.example.hakatonapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hakatonapp.R;
import com.example.hakatonapp.activity.MainActivity;

public class StartFragment extends Fragment {
    Button btn_log;
    public static StartFragment newInstance() {
        return new StartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.start_layout, container,false);
        btn_log = v.findViewById(R.id.btn_log);
        btn_log.setOnClickListener(view->{
            ((MainActivity)getContext()).replaceFragment(AuthFragment.newInstance(), true);
//        getActivity().getSupportFragmentManager().beginTransaction().
//        replace(R.id.container, AuthFragment.newInstance(),"authFrag").addToBackStack(null).commit();
        });
        return v;
    }
}
