package com.example.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private  int mColorResourceId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> wordArrayList,int colorResourceId) {
        super(context, 0,  wordArrayList);
        mColorResourceId=colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView=convertView;
        if (listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        LinearLayout root=listItemView.findViewById(R.id.textViewsRoot);
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        root.setBackgroundColor(color);

            Word currentWord=getItem(position);
            TextView defaultTranslation=listItemView.findViewById(R.id.default_text_view);
            defaultTranslation.setText(currentWord.getDefaultTranslation());
            TextView miwokTranslation=listItemView.findViewById(R.id.miwok_text_view);
            miwokTranslation.setText(currentWord.getMiwokTranslation());

        ImageView imageView=listItemView.findViewById(R.id.image);
            if (currentWord.hasImage()){
                imageView.setImageResource(currentWord.getImageResourceId());
                imageView.setVisibility(View.VISIBLE);
            }else {
                imageView.setVisibility(View.GONE);
            }
        return listItemView;
    }
    //Adapterviews listView and gridView
}
