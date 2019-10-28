package com.example.hw06_group22;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class AvatarFragment extends Fragment {
    ImageButton F1,F2,F3,M1,M2,M3;
    StudentData data = new StudentData();

    private OnImageSelected mListener;

    public interface OnImageSelected {
        public void gotoMyProfileFromAvatar(@DrawableRes int image,StudentData data);
    }
    public AvatarFragment() {
        // Required empty public constructor
    }

    public static AvatarFragment newInstance(StudentData data) {
        Bundle bundle = new Bundle();
        bundle.putString("FirstName", data.FirstName);
        bundle.putString("LastName", data.LastName);
        bundle.putString("Department", data.Department);
        bundle.putString("StudentID", data.StudentID);
        bundle.putInt("image", data.image);

        AvatarFragment fragment = new AvatarFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        F1=view.findViewById(R.id.F1);
        F2=view.findViewById(R.id.F2);
        F3=view.findViewById(R.id.F3);
        M1=view.findViewById(R.id.M1);
        M2=view.findViewById(R.id.M2);
        M3=view.findViewById(R.id.M3);
        if (getArguments() != null) {
            data.FirstName = getArguments().getString("FirstName");
            data.LastName = getArguments().getString("LastName");
            data.Department = getArguments().getString("Department");
            data.StudentID = getArguments().getString("StudentID");
            data.image = getArguments().getInt("image");
        }
        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.image=R.drawable.avatar_f_1;
                mListener.gotoMyProfileFromAvatar(R.drawable.avatar_f_1,data);
            }
        });
        F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.image=R.drawable.avatar_f_2;
                mListener.gotoMyProfileFromAvatar(R.drawable.avatar_f_2,data);
            }
        });
        F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.image=R.drawable.avatar_f_3;
                mListener.gotoMyProfileFromAvatar(R.drawable.avatar_f_3,data);
            }
        });
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.image=R.drawable.avatar_m_1;
                mListener.gotoMyProfileFromAvatar(R.drawable.avatar_m_1,data);
            }
        });
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.image=R.drawable.avatar_m_2;
                mListener.gotoMyProfileFromAvatar(R.drawable.avatar_m_2,data);
            }
        });
        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.image=R.drawable.avatar_m_3;
                mListener.gotoMyProfileFromAvatar(R.drawable.avatar_m_3,data);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        mListener=(OnImageSelected) context;
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
