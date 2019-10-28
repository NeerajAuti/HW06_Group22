package com.example.hw06_group22;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<StudentData> selected=new MutableLiveData<StudentData>();

    public void select(StudentData item) {
        selected.setValue(item);
    }

    public LiveData<StudentData> getSelected() {
        return selected;
    }

}
