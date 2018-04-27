package com.example.juanalvaropupo.interaptskillsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Tab1 extends Fragment {

    private RecyclerView recyclerView;
    private List<Students> studentsList;
    private AdapterRecyclerView adapterRecyclerView;

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
        setUpStudentsList();
    }

    private void setUpStudentsList() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        adapterRecyclerView = new AdapterRecyclerView(studentsList);
        recyclerView.setAdapter(adapterRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterRecyclerView.notifyDataSetChanged();
    }

}
