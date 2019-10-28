package com.example.hw06_group22;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements MyProfileFragment.OnFragmentInteractionListener,AvatarFragment.OnImageSelected {

    ConstraintLayout container;
    MyProfileFragment  myProfileFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");
        container = findViewById(R.id.container);
        myProfileFragment=new MyProfileFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,myProfileFragment).commit();
        //container.addView();

    }

    @Override
    public void gotoSelectAvatar() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AvatarFragment(), "avatar").addToBackStack(null).commit();
    }

    @Override
    public void gotoDisplayScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DisplayFragment(), "display").commit();
    }

    @Override
    public void gotoMyProfile(@DrawableRes int image) {
        getSupportFragmentManager().popBackStack();
        myProfileFragment.setImageButton(image);
    }
}
