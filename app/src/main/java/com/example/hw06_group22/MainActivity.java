// Assignment : Homework 06
// Group 22
// Members: Neeraj Vilas Auti
//          Vedija Jagtap


package com.example.hw06_group22;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements MyProfileFragment.OnFragmentInteractionListener, AvatarFragment.OnImageSelected, DisplayFragment.OnFragmentInteractionListener {

    ConstraintLayout container;
    StudentData Global_Student =new StudentData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");
        container = findViewById(R.id.container);
        MyProfileFragment myProfileFragment;
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        if (sharedPreferences.contains("StudentDetails")) {
            String userInfoListJsonString = sharedPreferences.getString("StudentDetails", "");
            Gson gson = new Gson();
            Global_Student = gson.fromJson(userInfoListJsonString, StudentData.class);
            Log.d("test3", "onCreate: 123 " + Global_Student);
            myProfileFragment = MyProfileFragment.newInstance(Global_Student.image, Global_Student);
            //myProfileFragment = new MyProfileFragment();
        } else
            myProfileFragment = new MyProfileFragment();
        //container.addView();
        getSupportFragmentManager().beginTransaction().add(R.id.container, myProfileFragment).commit();

    }

    @Override
    public void gotoSelectAvatar(StudentData data) {
        AvatarFragment avatarFragment = AvatarFragment.newInstance(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,avatarFragment).commit();
    }

    @Override
    public void gotoDisplayScreen(StudentData data) {
        Gson gson = new Gson();
        String userInfoListJsonString = gson.toJson(data);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("StudentDetails", userInfoListJsonString);
        editor.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DisplayFragment()).commit();
    }

    @Override
    public void gotoMyProfileFromAvatar(@DrawableRes int image,StudentData data) {
        MyProfileFragment MyProfileFromAvatar=MyProfileFragment.newInstance(image, data);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, MyProfileFromAvatar).commit();
    }

    @Override
    public void gotoMyProfileFromDisplay(StudentData data) {
        MyProfileFragment MyProfileFromDisplay=MyProfileFragment.newInstance(data.image,data);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, MyProfileFromDisplay).commit();
    }
}
