package com.example.juanalvaropupo.interaptskillsapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Tab1 extends Fragment {

    private RecyclerView recyclerView;
    private List<Students> studentsList;
    private AdapterRecyclerView adapterRecyclerView;
    private FloatingActionButton fab;
    private EditText dialogEditext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_students_list, container, false);
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
        studentsList = new ArrayList<>();

        dialogEditext = getActivity().findViewById(R.id.dialog_edittext);
        fab = getActivity().findViewById(R.id.fab);
        setOnClickListener();
        setUpStudentsList();
    }

    private void setOnClickListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View subview = LayoutInflater.from(getActivity()).inflate(R.layout.add_game_dialog_layout, null, false);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Add a new student to the class")
                        .setView(subview)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

//                                String studentNameInput = dialogEditext.getText().toString();
//
//                                Students students = new Students(studentNameInput);
//                                studentsList.add(students);
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

    private void setUpStudentsList() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        adapterRecyclerView = new AdapterRecyclerView(studentsList);
        recyclerView.setAdapter(adapterRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterRecyclerView.notifyDataSetChanged();
    }


    }


