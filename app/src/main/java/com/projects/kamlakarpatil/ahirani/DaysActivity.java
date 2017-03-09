package com.projects.kamlakarpatil.ahirani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class DaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("monday", "somwar"));
        words.add(new Word("tuesday", "managalwar"));
        words.add(new Word("wednesday", "budhwar"));
        words.add(new Word("thursday", "gurwar"));
        words.add(new Word("friday", "shukrawar"));
        words.add(new Word("saturday", "shaniwar"));
        words.add(new Word("sunday", "raiwar"));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_days);
        ListView wordsListView = (ListView) findViewById(R.id.words_listview);
        wordsListView.setAdapter(wordAdapter);


    }
}
