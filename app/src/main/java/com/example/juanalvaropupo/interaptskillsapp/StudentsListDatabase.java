package com.example.juanalvaropupo.interaptskillsapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(version = 1, entities = Students.class)
abstract class StudentsListDatabase extends RoomDatabase{

    public abstract StudentsDao studentsDao();
}
