package com.example.juanalvaropupo.interaptskillsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        return view;
    }

    public static Tab2 newInstance() {
        
        Bundle args = new Bundle();
        
        Tab2 fragment = new Tab2();
        fragment.setArguments(args);
        return fragment;
    }
}
