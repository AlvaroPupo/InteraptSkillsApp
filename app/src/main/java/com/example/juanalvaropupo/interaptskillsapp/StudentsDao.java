package com.example.juanalvaropupo.interaptskillsapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentsDao {

    @Query("SELECT * FROM students")
    List<Students> getStudents();

    @Insert
    void addStudent(Students students);

    @Update
    void updateStudentList(Students students);

    @Delete
    void deleteStudent(Students students);
}
