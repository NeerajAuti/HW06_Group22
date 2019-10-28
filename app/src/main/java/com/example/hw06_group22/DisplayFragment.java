package com.example.hw06_group22;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayFragment extends Fragment {

    ImageView iv_DisplayImage;
    TextView tv_Name,tv_Department,tv_StudentID;
    Button btn_Edit;

    final StudentData current=new StudentData();
    private OnFragmentInteractionListener mListener;

    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        iv_DisplayImage=view.findViewById(R.id.iv_DisplayImage);
        tv_Department=view.findViewById(R.id.tv_Department);
        tv_StudentID=view.findViewById(R.id.tv_StudentID);
        tv_Name=view.findViewById(R.id.tv_Name);
        btn_Edit=view.findViewById(R.id.btn_Edit);
        final SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        model.getSelected().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                StudentData data = (StudentData)o;
                current.LastName=data.LastName;
                current.FirstName=data.FirstName;
                current.Department=data.Department;
                current.StudentID=data.StudentID;
                current.image=data.image;
                Log.d("test", "onChanged: "+data.toString());
                tv_Name.setText(data.FirstName+" "+data.LastName);
                tv_Department.setText(data.Department);
                tv_StudentID.setText(data.StudentID);
                iv_DisplayImage.setImageResource(data.image);
            }
        });

        btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.select(current);
                mListener.gotoMyProfileFromDisplay(current);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void gotoMyProfileFromDisplay(StudentData data);
    }
}
