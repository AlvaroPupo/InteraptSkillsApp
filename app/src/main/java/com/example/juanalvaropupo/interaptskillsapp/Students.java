package com.example.juanalvaropupo.interaptskillsapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Students {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String studentName;

    public Students(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String setStudentName(String studentName) {
        this.studentName = studentName;
        return studentName;
    }
}
