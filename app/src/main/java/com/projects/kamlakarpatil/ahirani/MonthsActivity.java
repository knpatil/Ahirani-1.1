package com.projects.kamlakarpatil.ahirani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MonthsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("january", "janewari"));
        words.add(new Word("february", "februwari"));
        words.add(new Word("march", "march"));
        words.add(new Word("april", "april"));
        words.add(new Word("may", "me"));
        words.add(new Word("june", "jun"));
        words.add(new Word("july", "julai"));
        words.add(new Word("august", "aagust"));
        words.add(new Word("september", "saptember"));
        words.add(new Word("october", "octomber"));
        words.add(new Word("november", "november"));
        words.add(new Word("december", "december"));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_months);
        ListView wordsListView = (ListView) findViewById(R.id.words_listview);
        wordsListView.setAdapter(wordAdapter);
    }
}
