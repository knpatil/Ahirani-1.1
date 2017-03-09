package com.projects.kamlakarpatil.ahirani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "baap"));
        words.add(new Word("mother", "mai"));
        words.add(new Word("brother", "bhau"));
        words.add(new Word("sister", "bahin"));
        words.add(new Word("grand-father", "baappa"));
        words.add(new Word("grand-mother", "aaji"));
        words.add(new Word("uncle", "chulta"));
        words.add(new Word("aunty", "maushi"));
        words.add(new Word("cousin-brother", "chulat-bhau"));
        words.add(new Word("cousin-sister", "chulat-bahin"));
        words.add(new Word("nephew", "bhasa"));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView wordsListView = (ListView) findViewById(R.id.words_listview);
        wordsListView.setAdapter(wordAdapter);
    }
}
