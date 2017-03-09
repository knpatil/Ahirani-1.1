package com.projects.kamlakarpatil.ahirani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("What is your name?", "Tuna naav kai she?"));
        words.add(new Word("My name is ...", "Mana naav ... she."));
        words.add(new Word("Where are you going?", "Tu kothe jai rhaina?"));
        words.add(new Word("What are you doing?", "Tu kai kari rhaina?"));
        words.add(new Word("Come here.", "Aatha ye."));
        words.add(new Word("How are you?", "Tu kasa he?"));
        words.add(new Word("I am fine.", "Me changla he."));
        words.add(new Word("Are you also coming?", "Tu bhi ii rhaina ka?"));
        words.add(new Word("Yes, I am also coming.", "Ha, mi bhi ii rhainu na."));
        words.add(new Word("Let's go then.", "chalana mang."));
        words.add(new Word("Which school you go?", "Tu konati shalama jaas?"));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView wordsListView = (ListView) findViewById(R.id.words_listview);
        wordsListView.setAdapter(wordAdapter);
    }
}
