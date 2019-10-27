package com.example.hw06_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    EditText et_FirstName, et_LastName, et_StudentID;
    RadioGroup rg_Department;
    RadioButton rb_CS, rb_SIS, rb_BIO, rb_Other;
    Button btn_Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");
    }
}
