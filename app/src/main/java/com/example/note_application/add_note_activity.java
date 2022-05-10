package com.example.note_application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.note_application.databases.db_notes;

public class add_note_activity extends AppCompatActivity {
    ImageView imgsave;
    AlertDialog.Builder builder;
    EditText txttitle, txtnotbody;
    String txt1, txt2;
    db_notes dbnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        imgsave = findViewById(R.id.imgsave);
        txtnotbody = findViewById(R.id.txtbody);
        txttitle = findViewById(R.id.txttitle);
        dbnote = new db_notes(this);

//
//         builder = new AlertDialog.Builder(add_note_activity.this);
//        builder.setTitle("You did not save the note");
//        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Intent intent = new Intent(add_note_activity.this,MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                builder.setCancelable(true);
//            }
//        });
        txt1 = txttitle.getText().toString();
        txt2 = txtnotbody.getText().toString();
        if (!"".equals(txt1) && !"".equals(txt2)) {
            onBackPressed();
        }



//        imgsave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                if (txt1.isEmpty()){
//                    txttitle.setError("fill the title");
//                    txttitle.requestFocus();
//                    return;
//                }
//
//            if (txt2.isEmpty()){
//                txtnotbody.setError("fill the title");
//                txtnotbody.requestFocus();
//                return;
//            }
//
//            else{
//                Long result =  dbnote.insertdata(txt1,txt2);
//                if (result != -1){
//
//                    Toast.makeText(add_note_activity.this, "Sucessfully inserted", Toast.LENGTH_SHORT).show();
//                    txtnotbody.setText("");
//                    txttitle.setText("");
//                }else{
//                    Toast.makeText(add_note_activity.this, "Unsucessfully insertation", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//
//
//            }
//        })
    }


    public void ins(String x , String y)
    {
        Long result = dbnote.insertdata(x, y);
        if (result != -1) {
            txttitle.setText("");
            txtnotbody.setText("");
        } else {
            Toast.makeText(add_note_activity.this, "Unsucessfully insertation", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        builder = new AlertDialog.Builder(add_note_activity.this);
        builder.setTitle("You did not save the note");
        builder.setCancelable(false);
        builder.setPositiveButton("back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(add_note_activity.this,MainActivity.class);
                startActivity(intent);
                onSuperBackPressed();
            }
        });
        txt1 = txttitle.getText().toString();
        txt2 = txtnotbody.getText().toString();
        builder.setNegativeButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (txt1.isEmpty()){
                    txttitle.setError("fill it");
                    txttitle.requestFocus();
                    return;

                    }
                if (txt2.isEmpty()){
                    txtnotbody.setError("fill it");
                    txtnotbody.requestFocus();
                    return;

                }else
                {
                    ins(txt1,txt2);
                    onSuperBackPressed();

                }
            }
        });
        builder.show();

    }

    public void onSuperBackPressed(){
        super.onBackPressed();
    }
}