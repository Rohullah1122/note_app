package com.example.note_application.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db_notes extends SQLiteOpenHelper {
    SQLiteDatabase mydb;
//    int id1 =1;
//    String note1 = "hal" ,
//            String2 = "notebody";

    public db_notes(@Nullable Context context) {
        super(context,"db_note",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Notes(_id integer primary key autoincrement,notetitle varchar,Notebody varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public  long insertdata(String note,String notebody){
        ContentValues values = new ContentValues();
        values.put("notetitle",note);
        values.put("Notebody",notebody);
        mydb = this.getWritableDatabase();
        return mydb.insert("Notes",null,values);
    }

    public Cursor getData(){
        mydb = this.getWritableDatabase();
        return mydb.rawQuery("Select * from Notes",null);
    }

    public Cursor find(int id){
        mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from Notes where _id=?",new String[]{String.valueOf(id)});
        return cursor;
    }

    public long update(int id,String note,String notebody){
        ContentValues values = new ContentValues();
        values.put("_id",id);
        values.put("notetitle",note);
        values.put("Notebody",notebody);
        mydb = this.getWritableDatabase();
        return  mydb.update("Notes",values,"_id = ?",new String[]{String.valueOf(id)});
    }
    public long Delete(int id){
        mydb = this.getWritableDatabase();
        return mydb.delete("Notes","_id = ?",new String[]{String.valueOf(id)});
    }


}
