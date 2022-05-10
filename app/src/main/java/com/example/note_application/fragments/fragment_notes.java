package com.example.note_application.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.note_application.R;
import com.example.note_application.adabters.list_noteadabter;
import com.example.note_application.classes.cls_noteatterbiutes;
import com.example.note_application.databases.db_notes;

import java.util.ArrayList;


public class fragment_notes extends Fragment {
    ListView listView;
    db_notes note;
    ArrayList<cls_noteatterbiutes>ALNA;
    list_noteadabter adabter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_notes() {

    }




    // TODO: Rename and change types and number of parameters
    public static fragment_notes newInstance(String param1, String param2) {
        fragment_notes fragment = new fragment_notes();
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
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        listView = view.findViewById(R.id.lvnotes);
        note = new db_notes(getContext());
        Cursor cursor = note.getData();
        ALNA = new ArrayList<>();
        while (cursor.moveToNext()){
            ALNA.add(new cls_noteatterbiutes(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
        }
         adabter = new list_noteadabter(getContext(),ALNA);
        listView.setAdapter(adabter);

        return view;
    }
}