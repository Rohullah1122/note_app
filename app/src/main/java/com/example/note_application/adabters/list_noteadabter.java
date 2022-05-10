package com.example.note_application.adabters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.note_application.MainActivity;
import com.example.note_application.R;
import com.example.note_application.classes.cls_noteatterbiutes;
import com.example.note_application.databases.db_notes;
import com.example.note_application.open_note;

import java.util.ArrayList;

public class list_noteadabter extends BaseAdapter {
    Context context;
    ArrayList<cls_noteatterbiutes> ALNA;
    db_notes notes;

    public list_noteadabter(Context context, ArrayList<cls_noteatterbiutes> ALNA) {
        this.context = context;
        this.ALNA = ALNA;
        notes = new db_notes(context);
    }

    @Override
    public int getCount() {
        return ALNA.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.layout_notes,null);
        TextView tv1 = view.findViewById(R.id.tvtitlelayout);
        TextView tv2 = view.findViewById(R.id.txtbodylayout);
        tv1.setText(ALNA.get(i).getNotetitle());
        tv2.setText(ALNA.get(i).getNotebody());
        int id = ALNA.get(i).getNoteid();


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent intent1 = new Intent(context, open_note.class);
                intent1.putExtra("id",id);
                intent1.putExtra("tv1",tv1.getText().toString());
                intent1.putExtra("tv2",tv2.getText().toString());
                context.startActivity(intent1);

            }

        });


        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete the note");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    notes.Delete(id);
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context ,"shod", Toast.LENGTH_SHORT).show();
                        builder.setCancelable(true);
                    }
                });


                builder.show();
                return true;
            }
        });


        return view;
    }


}
