package com.example.android_development_assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    private List<StudentsData> studentsDataList = new ArrayList<>();


    public CustomAdapter(ViewDetailsActivity v, List<StudentsData> l) {
        c = v;
        studentsDataList = l;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.item, null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tn.setText("Name:"+studentsDataList.get(position).getName());

        holder.ta.setText("Address:"+studentsDataList.get(position).getAddress());
        holder.tf.setText("Faculty:"+studentsDataList.get(position).getFaculty());
        holder.ts.setText("Semester:"+studentsDataList.get(position).getSemester());
    }

    @Override
    public int getItemCount() {
        return studentsDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tn;
        TextView ta;
        TextView tf;
        TextView ts;


        public MyViewHolder(View convertView) {

            super(convertView);
            tn = convertView.findViewById(R.id.name);
            ta = convertView.findViewById(R.id.address);
            tf = convertView.findViewById(R.id.faculty);
            ts = convertView.findViewById(R.id.sem);

        }

    }
}
