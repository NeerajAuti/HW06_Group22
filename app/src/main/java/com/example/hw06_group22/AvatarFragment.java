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

    private OnImageSelected mListener;

    public interface OnImageSelected {
        public void gotoMyProfile(@DrawableRes int image);
    }
    public AvatarFragment() {
        // Required empty public constructor
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

        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.gotoMyProfile(R.drawable.avatar_f_1);
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
