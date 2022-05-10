package com.example.note_application;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.note_application.databases.db_notes;

public class open_note extends AppCompatActivity {
    EditText tvtitle,tvbody;
    int id;
    String tv1,tv2;
    String s1,s2;
    String t1,t2;
    AlertDialog.Builder builder;



    db_notes dbnote;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_note);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        tv1 = intent.getStringExtra("tv1");
        tv2 = intent.getStringExtra("tv2");
        tvtitle = findViewById(R.id.tvtitle);


        tvbody = findViewById(R.id.tvbody);
        s1 =tvtitle.getText().toString();
        s2 = tvbody.getText().toString();

        imageView = findViewById(R.id.imgsave);
        dbnote = new db_notes(this);
        tvtitle.setText(tv1);
        tvbody.setText(tv2);





        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = tvtitle.getText().toString();
                t2 = tvbody.getText().toString();

                if (t1.isEmpty()){
                    tvtitle.setError("fille the title");
                    tvtitle.requestFocus();
                    return;
                }

                if (t2.isEmpty()){
                    tvbody.setError("fille the title");
                    tvbody.requestFocus();
                    return;
                }

                Long result =  dbnote.update(id,t1,t2);
                if (result != -1){

                    find(id);

                }else{
                    Toast.makeText(open_note.this, "nashod", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }


    public void find(int id){

        Cursor cursor = dbnote.find(id);
        if (cursor.moveToNext()){
            id = cursor.getInt(0);
            s1 = cursor.getString(1);
            s2 = cursor.getString(2);

            tvbody.setText(t2);
            tvtitle.setText(t1);
        }


    }

}