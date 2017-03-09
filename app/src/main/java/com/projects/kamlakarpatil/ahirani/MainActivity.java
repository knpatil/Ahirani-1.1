package com.projects.kamlakarpatil.ahirani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersOnClickListener();
        familyOnClickListener();
        colorsOnClickListener();
        daysOnClickListener();
        phrasesOnClickListener();
        monthsOnClickListener();
    }

    private void monthsOnClickListener() {
        TextView tvMonths = (TextView) findViewById(R.id.months);
        tvMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked on Months TextView.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, MonthsActivity.class);
                startActivity(i);
            }
        });
    }

    private void phrasesOnClickListener() {
        TextView tvPhrases = (TextView) findViewById(R.id.phrases);
        tvPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked on Phrases TextView.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(i);
            }
        });
    }

    private void daysOnClickListener() {
        TextView tvDays = (TextView) findViewById(R.id.days);
        tvDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked on Days TextView.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, DaysActivity.class);
                startActivity(i);
            }
        });
    }

    private void colorsOnClickListener() {
        TextView tvColors = (TextView) findViewById(R.id.colors);
        tvColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked on Colors TextView.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(i);
            }
        });
    }

    private void familyOnClickListener() {
        // Family on click listener
        TextView tvFamily = (TextView) findViewById(R.id.family);
        tvFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked on Family TextView.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(i);
            }
        });
    }

    private void numbersOnClickListener() {
        // Numbers on click listener
        TextView tvNumbers = (TextView) findViewById(R.id.numbers);
        tvNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked on Numbers TextView.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(i);
            }
        });
    }


}
