package com.example.note_application.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.note_application.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class bottom_fragment extends BottomSheetDialogFragment {

    ImageButton imgd,imgu,imgc,imgo;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bottom_fragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static bottom_fragment newInstance(String param1, String param2) {
        bottom_fragment fragment = new bottom_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bottom_fragment, container, false);

        imgc = view.findViewById(R.id.btn_cancel);
        imgo= view.findViewById(R.id.btn_open);
        imgd = view.findViewById(R.id.btn_delete);
        imgu = view.findViewById(R.id.btn_update);







        return view;
    }
}