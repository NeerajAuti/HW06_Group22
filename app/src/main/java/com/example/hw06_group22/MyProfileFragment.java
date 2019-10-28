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
import androidx.lifecycle.Observer;
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

import com.google.gson.Gson;

public class MyProfileFragment extends Fragment {

    private SharedViewModel model;
    ImageButton imageButton;
    private EditText et_FirstName, et_LastName, et_StudentID;
    RadioGroup rg_Department;
    RadioButton rb_CS, rb_SIS, rb_BIO, rb_Other;
    Button btn_Save;
    private OnFragmentInteractionListener mListener;
    @DrawableRes
    int current_image;

    public void setImageButton(@DrawableRes int image) {
//        imageButton.setImageDrawable(getResources().getDrawable(R.drawable.avatar_f_1,null));
        Log.d("test1", "onClick: " + et_FirstName.getText().toString());
        et_FirstName.setText("456");
        current_image = R.drawable.avatar_f_1;
        Log.d("test1", "onClick: " + et_FirstName.getText().toString());
    }

    public void setStudentDetails(StudentData data) {
        Log.d("test3", "setStudentDetails: " + data.toString());
        et_FirstName.setText(data.FirstName);
        et_LastName.setText(data.LastName);
        et_StudentID.setText(data.StudentID);
        imageButton.setImageResource(data.image);
        switch (data.Department) {
            case "CS":
                rb_CS.setChecked(true);
                rb_BIO.setChecked(false);
                rb_Other.setChecked(false);
                rb_SIS.setChecked(false);
                break;
            case "BIO":
                rb_CS.setChecked(false);
                rb_BIO.setChecked(true);
                rb_Other.setChecked(false);
                rb_SIS.setChecked(false);
                break;
            case "Other":
                rb_CS.setChecked(false);
                rb_BIO.setChecked(false);
                rb_Other.setChecked(true);
                rb_SIS.setChecked(false);
                break;
            case "SIS":
                rb_CS.setChecked(false);
                rb_BIO.setChecked(false);
                rb_Other.setChecked(false);
                rb_SIS.setChecked(true);
                break;
            default:
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        public void gotoSelectAvatar();

        public void gotoDisplayScreen(StudentData data);
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
                StudentData data = new StudentData();

                if (rg_Department.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity(), "Select Department", Toast.LENGTH_SHORT);
                } else if (et_FirstName.getText().toString() == null || et_FirstName.getText().toString() == "") {
                    Toast.makeText(getActivity(), "Enter First Name", Toast.LENGTH_SHORT);
                } else if (et_LastName.getText().toString() == null || et_LastName.getText().toString() == "") {
                    Toast.makeText(getActivity(), "Enter Last Name", Toast.LENGTH_SHORT);

                } else if (et_StudentID.getText().toString() == null || et_StudentID.getText().toString() == "") {
                    Toast.makeText(getActivity(), "Enter Student ID", Toast.LENGTH_SHORT);
                } else {
                    if (rb_BIO.isChecked())
                        data.Department = "BIO";
                    if (rb_CS.isChecked())
                        data.Department = "CS";
                    if (rb_Other.isChecked())
                        data.Department = "Other";
                    if (rb_SIS.isChecked())
                        data.Department = "SIS";
                    data.FirstName = et_FirstName.getText().toString();
                    data.LastName = et_LastName.getText().toString();
                    data.StudentID = et_StudentID.getText().toString();
                    current_image = R.drawable.avatar_f_1;
                    data.image = current_image;
                    model.select(data);
                    mListener.gotoDisplayScreen(data);
                }
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
