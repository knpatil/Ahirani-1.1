package com.projects.kamlakarpatil.ahirani;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("orange", "narangi", R.drawable.color_orange, R.raw.audio_orange));
        words.add(new Word("blue", "neela", R.drawable.color_blue,R.raw.audio_blue));
        words.add(new Word("red", "laal", R.drawable.color_red, R.raw.audio_red));
        words.add(new Word("green", "hara", R.drawable.color_green, R.raw.audio_green));
        words.add(new Word("black", "kaya", R.drawable.color_black, R.raw.audio_black));
        words.add(new Word("yellow", "piwya", R.drawable.color_yellow, R.raw.audio_yellow));
        words.add(new Word("pink", "gulabi", R.drawable.color_pink, R.raw.audio_pink));
        words.add(new Word("purple", "jambhya", R.drawable.color_purple, R.raw.audio_purple));
        words.add(new Word("brown", "tapkiri", R.drawable.color_brown, R.raw.audio_brown));
        words.add(new Word("white", "dhavya", R.drawable.color_white, R.raw.audio_white));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView wordsListView = (ListView) findViewById(R.id.words_listview);
        wordsListView.setAdapter(wordAdapter);

        wordsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(NumbersActivity.this, "item clicked.", Toast.LENGTH_SHORT).show();

                // Word currentItem = (Word) parent.getItemAtPosition(position);
                Word currentItem = words.get(position);
                if ( currentItem.hasAudio()) {
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, currentItem.getmAudioResourceId());
                    mMediaPlayer.start();
                    //mMediaPlayer.reset();
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

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
