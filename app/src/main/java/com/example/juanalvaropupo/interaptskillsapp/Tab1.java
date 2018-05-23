package com.example.juanalvaropupo.interaptskillsapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Tab1 extends Fragment {

    private RecyclerView recyclerView;
    private AdapterRecyclerView adapterRecyclerView;
    private FloatingActionButton floatingActionButton;
    private StudentsListDatabase studentsListDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_students_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static Tab1 newInstance() {

        Bundle args = new Bundle();

        Tab1 fragment = new Tab1();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onStart() {
        super.onStart();
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        studentsListDatabase = ((StudentApplication) getActivity().getApplicationContext()).getDatabase();
        floatingActionButton = getActivity().findViewById(R.id.fab);
        setOnClickListener();
        setUpStudentsList();
    }
    private void setUpStudentsList() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecyclerView = new AdapterRecyclerView(studentsListDatabase.studentsDao().getStudents());
        recyclerView.setAdapter(adapterRecyclerView);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapterRecyclerView.notifyDataSetChanged();
    }

    private void setOnClickListener() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                View subview = LayoutInflater.from(getActivity()).inflate(R.layout.add_game_dialog_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Add a new student to the class");

                        final EditText input = new EditText(getActivity());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                input.setLayoutParams(lp);
                builder.setView(input);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                    Students students = new Students(input.getText().toString());
                                    addStudentsToDatabase(students);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void addStudentsToDatabase(Students students) {
        studentsListDatabase.studentsDao().addStudent(students);
        adapterRecyclerView.updateList(studentsListDatabase.studentsDao().getStudents());
    }
}