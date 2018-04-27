package com.example.juanalvaropupo.interaptskillsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);
        return view;
    }

    public static Tab3 newInstance() {
        
        Bundle args = new Bundle();
        
        Tab3 fragment = new Tab3();
        fragment.setArguments(args);
        return fragment;
    }
}
