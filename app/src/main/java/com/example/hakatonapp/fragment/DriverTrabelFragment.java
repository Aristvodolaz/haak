package com.example.hakatonapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hakatonapp.R;
import com.example.hakatonapp.adapter.DriverAdapter;
import com.example.hakatonapp.data.DriverData;

import java.util.ArrayList;
import java.util.List;

public class DriverTrabelFragment extends Fragment {

    List<DriverData>data;
    RecyclerView recyclerView;
    ImageView backArrow;
    public static DriverTrabelFragment newInstance() {
        return new DriverTrabelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.driver_travel_layout, container,false);

        backArrow = v.findViewById(R.id.back_arrow);
        recyclerView = v.findViewById(R.id.recycler_view);

        backArrow.setOnClickListener(view->{getActivity().getSupportFragmentManager().popBackStack();});

        visableAdapter();
        return v;
    }

    private void visableAdapter(){
        data = new ArrayList<>();
        if (data.isEmpty() || data ==null){
            Toast.makeText(getContext(), "Список маршрутов пуст!",Toast.LENGTH_LONG).show();
        } else {
            DriverAdapter adapter = new DriverAdapter(getContext(), data);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
    }
}
