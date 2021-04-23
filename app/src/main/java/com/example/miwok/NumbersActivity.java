package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private static  final String TAG=NumbersActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


//        //ArrayList stores objects only
//        ArrayList<String> numberWords=new ArrayList<String>();
//        numberWords.add("One");
//        numberWords.add("Two");
//        numberWords.add("Three");
//        numberWords.add("Four");
//        numberWords.add("Five");
//        numberWords.add("Six");
//        numberWords.add("Seven");
//        numberWords.add("Eight");
//        numberWords.add("Nine");
//        numberWords.add("Ten");

//        for (int i=0;i<numberWords.size();i++){
//            Log.d(TAG,"Word at index "+i+" : "+numberWords.get(i));
//        }
//        LinearLayout rootLayout=(LinearLayout) findViewById(R.id.rootView);
//        for (int i=0;i<numberWords.size();i++){
//            TextView wordView=new TextView(NumbersActivity.this);
//            wordView.setText(numberWords.get(i));
//            rootLayout.addView(wordView);
//        }

        //T-data type
       /** ArrayAdapter<String> itemAdapter=new ArrayAdapter<>(this, R.layout.list_item,numberWords);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
        //int index=0;
        **/

       ArrayList<Word> words=new ArrayList<Word>();
       words.add(new Word("one","luti",R.drawable.number_one));
        words.add(new Word("two","otiiko",R.drawable.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three));
        words.add(new Word("four","oyyisa",R.drawable.number_four));
        words.add(new Word("five","massokka",R.drawable.number_five));
        words.add(new Word("six","temmokkka",R.drawable.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine));
        words.add(new Word("ten","na'aach",R.drawable.number_ten));

        WordAdapter adapter=new WordAdapter(this,words,R.color.category_numbers);
        ListView listView=findViewById(R.id.list);
        listView.setAdapter(adapter);


//        while (index<numberWords.size()){
//            TextView wordView=new TextView(NumbersActivity.this);
//            wordView.setText(numberWords.get(0));
//            rootLayout.addView(wordView);
//            index++;
//        }





    }
}