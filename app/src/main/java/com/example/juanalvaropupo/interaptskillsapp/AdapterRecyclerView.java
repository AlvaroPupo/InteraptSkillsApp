package com.example.juanalvaropupo.interaptskillsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>{

    private List<Students> studentsList;
    private AdapterCallback adapterCallback;

    public AdapterRecyclerView (List<Students> studentsList) {
        this.studentsList = studentsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View studentsListView = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_list_layout, parent, false);
        return new ViewHolder(studentsListView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(studentsList.get(position));

        holder.itemView.setOnClickListener(holder.onClick(studentsList.get(position)));
        holder.itemView.setOnLongClickListener(holder.onLongClick(studentsList.get(position)));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public void updateList(List<Students> list){
        studentsList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.student_name_textview)
        protected TextView studentName;

        public ViewHolder (View studentsListView){
            super(studentsListView);
            ButterKnife.bind(this, itemView);
        }
        public void bind (Students students){
            studentName.setText(students.getStudentName());
        }

        public View.OnClickListener onClick(final Students students) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterCallback.rowClicked(students);
                }
            };
        }
        public View.OnLongClickListener onLongClick(final Students students){
            return new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    adapterCallback.rowLongClicked(students);
                    return true;
                }
            };
        }

    }
    public interface AdapterCallback {
        Context getContext();
        void rowClicked(Students students);
        void rowLongClicked(Students students);
    }

}
