package com.projects.kamlakarpatil.ahirani;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kamlakar.patil on 2/27/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> wordsList, int colorId) {
        super(context, 0, wordsList);
        mColorResourceId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        TextView tvAhiraniWord = (TextView) listItemView.findViewById(R.id.ahirani_word);
        tvAhiraniWord.setText(currentWord.getmAhiraniTranslation());

        TextView tvEnglishWord = (TextView) listItemView.findViewById(R.id.english_word);
        tvEnglishWord.setText(currentWord.getmDefaultTranslation());

        ImageView ivIcon = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        if (currentWord.hasImage()) {
            ivIcon.setImageResource(currentWord.getmImageResourceId());
            ivIcon.setVisibility(View.VISIBLE);
        } else {
            ivIcon.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        if ( ! currentWord.hasAudio() ) {
            ImageView ivPlayIcon = (ImageView) listItemView.findViewById(R.id.play_icon);
            ivPlayIcon.setVisibility(View.GONE);
        }
        return listItemView;
    }


}
