package com.example.hakatonapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<PlaceAdapter.PlaceAutocomplete> implements Filterable {


    private static final String TAG = "PlaceArrayAdapter";
    private final PlacesClient placesClient;
    private RectangularBounds mBounds;
    private ArrayList<PlaceAutocomplete> mResultList = new ArrayList<>();
    public Context context;

    public PlaceAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public class LabelHolder extends RecyclerView.ViewHolder {
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
