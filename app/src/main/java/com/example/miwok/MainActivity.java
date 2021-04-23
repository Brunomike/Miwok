package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public  void openNumbersList(View view){
        Intent intent=new Intent(MainActivity.this,NumbersActivity.class);
        startActivity(intent);
    }
    public  void openFamilyList(View view){
        Intent intent=new Intent(MainActivity.this,FamilyActivity .class);
        startActivity(intent);
    }
    public  void openColorsList(View view){
        Intent intent=new Intent(MainActivity.this,ColorsActivity.class);
        startActivity(intent);
    }
    public  void openPhrasesList(View view){
        Intent intent=new Intent(MainActivity.this,PhrasesActivity.class);
        startActivity(intent);
    }
//
//    public  class NumbersClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(v.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
//        }
//    }
}