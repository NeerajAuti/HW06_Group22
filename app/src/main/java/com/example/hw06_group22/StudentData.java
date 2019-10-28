package com.example.hw06_group22;

import androidx.annotation.NonNull;

public class StudentData {
    String FirstName,LastName,StudentID;

    public StudentData() {
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", StudentID='" + StudentID + '\'' +
                '}';
    }
}
