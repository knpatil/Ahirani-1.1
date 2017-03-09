package com.projects.kamlakarpatil.ahirani;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                        Log.v("NumbersActivity:", "AUDIOFOCUS_GAIN");
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };


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

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        
        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "ek", R.drawable.number_one, R.raw.audio_one));
        words.add(new Word("two", "done", R.drawable.number_two, R.raw.audio_two));
        words.add(new Word("three", "teen", R.drawable.number_three, R.raw.audio_three));
        words.add(new Word("four", "char", R.drawable.number_four, R.raw.audio_four));
        words.add(new Word("five", "paach", R.drawable.number_five, R.raw.audio_five));
        words.add(new Word("six", "saa", R.drawable.number_six, R.raw.audio_six));
        words.add(new Word("seven", "saat", R.drawable.number_seven, R.raw.audio_seven));
        words.add(new Word("eight", "aat", R.drawable.number_eight, R.raw.audio_eight));
        words.add(new Word("nine", "nau", R.drawable.number_nine, R.raw.audio_nine));
        words.add(new Word("ten", "da", R.drawable.number_ten, R.raw.audio_ten));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView wordsListView = (ListView) findViewById(R.id.words_listview);
        wordsListView.setAdapter(wordAdapter);

        wordsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(NumbersActivity.this, "item clicked.", Toast.LENGTH_SHORT).show();

                // Word currentItem = (Word) parent.getItemAtPosition(position);
                Word currentItem = words.get(position);

                Log.v("NumbersActivity:", "Current Word - " + currentItem);

                if (currentItem.hasAudio()) {
                    releaseMediaPlayer();

                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        mMediaPlayer = MediaPlayer.create(NumbersActivity.this, currentItem.getmAudioResourceId());
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
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

            // release audio focus
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
