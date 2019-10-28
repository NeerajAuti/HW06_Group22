package com.example.hw06_group22;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyProfileFragment extends Fragment {

    private SharedViewModel model;
    ImageButton imageButton;
    private EditText et_FirstName, et_LastName, et_StudentID;
    RadioGroup rg_Department;
    RadioButton rb_CS, rb_SIS, rb_BIO, rb_Other;
    Button btn_Save;
    private OnFragmentInteractionListener mListener;

    public void setImageButton(@DrawableRes int image) {
//        imageButton.setImageDrawable(getResources().getDrawable(R.drawable.avatar_f_1,null));
        Log.d("test1", "onClick: "+et_FirstName.getText().toString());
        et_FirstName.setText("456");
        Log.d("test1", "onClick: "+et_FirstName.getText().toString());
    }

    public interface OnFragmentInteractionListener {
        public void gotoSelectAvatar();

        public void gotoDisplayScreen();
    }

    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        btn_Save = view.findViewById(R.id.btn_Save);
        rb_CS = view.findViewById(R.id.rb_CS);
        rb_BIO = view.findViewById(R.id.rb_BIO);
        rb_Other = view.findViewById(R.id.rb_Other);
        rb_SIS = view.findViewById(R.id.rb_SIS);
        rg_Department = view.findViewById(R.id.rg_department);
        imageButton = view.findViewById(R.id.imageButton);
        et_FirstName = view.findViewById(R.id.et_FirstName);
        et_StudentID = view.findViewById(R.id.et_StudentID);
        et_LastName = view.findViewById(R.id.et_LastName);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.gotoSelectAvatar();
            }
        });
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentData data =new StudentData();
                data.FirstName=et_FirstName.getText().toString();
                data.LastName=et_LastName.getText().toString();
                data.StudentID=et_StudentID.getText().toString();
                model.select(data);

                mListener.gotoDisplayScreen();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        mListener = (OnFragmentInteractionListener) activity;
        super.onAttach(activity);
    }
}
