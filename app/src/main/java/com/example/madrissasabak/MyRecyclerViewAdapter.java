package com.example.madrissasabak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyVH>{
    List<Record> recordsList;

    public MyRecyclerViewAdapter(List<Record> recordsList) {
        this.recordsList = recordsList;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_sabak_item_layout, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=recordsList.get(position);
        holder.studentNameRV.setText(holder.data.getStdName());
        holder.SabakValueRV.setText(String.valueOf(holder.data.getSabak()));
        holder.sabkiValueRV.setText(String.valueOf(holder.data.getSabki()));
        holder.mazilValueRV.setText(String.valueOf(holder.data.getManzil()));
        holder.dateValueRV.setText(holder.data.getDate());
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    public class MyVH extends RecyclerView.ViewHolder{
        TextView studentNameRV, sabakLabel, SabakValueRV, SabkiLabelRV, sabkiValueRV,
                manzilLabelRV, mazilValueRV, dateValueRV;
        Record data;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            studentNameRV = itemView.findViewById(R.id.studentNameRV);
            sabakLabel = itemView.findViewById(R.id.sabakLabel);
            SabakValueRV = itemView.findViewById(R.id.SabakValueRV);
            SabkiLabelRV = itemView.findViewById(R.id.SabkiLabelRV);
            sabkiValueRV = itemView.findViewById(R.id.sabkiValueRV);
            manzilLabelRV = itemView.findViewById(R.id.manzilLabelRV);
            mazilValueRV = itemView.findViewById(R.id.mazilValueRV);
            dateValueRV = itemView.findViewById(R.id.dateValueRV);
        }
    }
}
