package com.example.juanalvaropupo.interaptskillsapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>{

    List<Students> studentsList;

    public AdapterRecyclerView (List<Students> studentsList) {
        this.studentsList = studentsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View studentsListView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_students_list, parent, false);
        return new ViewHolder(studentsListView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView studentName;

        public ViewHolder (View studentsListView){
            super(studentsListView);
            studentName = studentsListView.findViewById(R.id.student_name_textview);
            studentsListView.setOnClickListener(this);
        }
        public void bind (int position){
            studentName.setText(studentsList.get(position).getStudentName());
        }

        @Override
        public void onClick(View v) {
            studentsList.get(getAdapterPosition()).setStudentName("New name!");

            notifyDataSetChanged();
        }
    }

}
