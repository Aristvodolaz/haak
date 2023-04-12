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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Query;

public class DriverTrabelFragment extends Fragment {

    List<DriverData>data;
    RecyclerView recyclerView;
    ImageView backArrow;
    FirebaseDatabase firebaseDatabase;

    List <DriverData> dataList;

    DatabaseReference databaseReference;
    public static DriverTrabelFragment newInstance() {
        return new DriverTrabelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.driver_travel_layout, container,false);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Data");


        backArrow = v.findViewById(R.id.back_arrow);
        recyclerView = v.findViewById(R.id.recycler_view);

        backArrow.setOnClickListener(view->{getActivity().getSupportFragmentManager().popBackStack();});

        getdata();
        return v;
    }

    private void getdata() {
        databaseReference = firebaseDatabase.getReference("DriverData");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DriverData data =  dataSnapshot.getValue(DriverData.class);
                dataList.add(data);
                if (dataList.isEmpty() || dataList ==null){
                    Toast.makeText(getContext(), "Список маршрутов пуст!",Toast.LENGTH_LONG).show();
                } else {
                    DriverAdapter adapter = new DriverAdapter(getContext(), dataList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(adapter);
                }

    }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}
