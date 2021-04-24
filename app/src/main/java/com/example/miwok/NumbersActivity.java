package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class NumbersActivity extends AppCompatActivity {
    private static  final String TAG=NumbersActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private  MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange ==AUDIOFOCUS_LOSS_TRANSIENT ||focusChange ==AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        //Loss transient--we lost audio focus
                        //Loss transient can duck-can play audio at lower volume
                        //Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }else  if (focusChange ==AudioManager.AUDIOFOCUS_GAIN){
                        //Resume Playback
                        mMediaPlayer.start();
                    }else if (focusChange ==AudioManager.AUDIOFOCUS_LOSS){
                        //Stop Playback
                        releaseMediaPlayer();
                    }
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

       final ArrayList<Word> words=new ArrayList<Word>();
       words.add(new Word("one","luti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","temmokkka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","na'aach",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter adapter=new WordAdapter(this,words,R.color.category_numbers);
        ListView listView=findViewById(R.id.list);
        listView.setAdapter(adapter);
        //can refernce local variables declared with final
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this,"List item Clicked",Toast.LENGTH_SHORT).show();
                int audioResourceId=  words.get(position).getAudioResourceId();

                //Request audio focus for playback
                int result=mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        //Use the music stream
                        AudioManager.STREAM_MUSIC,
                        //Request permanent focus
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
                );

                if (result ==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    //mAudioManager.registerMediaButtonEventReceiver(RemoteControlReceiver);
                //We have audio focus

                //releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(view.getContext(),audioResourceId);
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer(){
        if (mMediaPlayer !=null){
            mMediaPlayer.release();

            mMediaPlayer=null;
        }
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }

}