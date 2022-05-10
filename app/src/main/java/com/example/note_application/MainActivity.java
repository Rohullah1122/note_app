package com.example.note_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.note_application.fragments.fragment_notes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    Fragment fragment;
//    ListView listView;
//    db_notes note;
//    ArrayList<cls_noteatterbiutes>ALNA;
//    list_noteadabter adabter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bn);
        frameLayout = findViewById(R.id.frameLayout);
        fragment = new fragment_notes();
        loadfragment(fragment);






        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.btn_addnot:
                        Intent intent = new Intent(MainActivity.this,add_note_activity.class);
                        startActivity(intent);
                        break;

                    case  R.id.btn_notes:
    //                        Intent inten1t = new Intent(MainActivity.this,add_note_activity.class);
//                        startActivity(inten1t);
//                        break;
                fragment = new fragment_notes();
                loadfragment(fragment);
                }

                return true;
            }
        });

    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the main_menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.top_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch(item.getItemId()) {
//            case R.id.btn_save:
//
//
//
//                break;
//            case R.id.btn_cancel:
//                Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//        return true;
//    }

    public void loadfragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment).commit();
    }
}