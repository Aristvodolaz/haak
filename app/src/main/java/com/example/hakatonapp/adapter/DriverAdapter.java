package com.example.hakatonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hakatonapp.data.DriverData;
import com.example.hakatonapp.R;

import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.LabelHolder> {

    private Context context;
    private List<DriverData> data;

    public DriverAdapter(Context context, List<DriverData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.driver_layout_item,parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LabelHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder {
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
