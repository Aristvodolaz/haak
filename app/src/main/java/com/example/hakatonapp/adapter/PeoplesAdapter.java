package com.example.hakatonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hakatonapp.R;
import com.example.hakatonapp.data.PeoplesData;

import java.util.List;

public class PeoplesAdapter extends RecyclerView.Adapter<PeoplesAdapter.LabelHolder> {

    private Context context;
    private List<PeoplesData> data;

    public PeoplesAdapter(Context context, List<PeoplesData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.peoples_layout_item,parent, false);
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
