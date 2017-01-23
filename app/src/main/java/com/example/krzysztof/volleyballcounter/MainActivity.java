package com.example.krzysztof.volleyballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int scoreFirst = 0;
    public int scoreSecond = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // dodanie punktu do pierwszego wyniku
    public void incrementScoreFirst() {
        if(scoreFirst<99) {
            scoreFirst += 1;
        }
        displayCurrentScore();
    }

    // odjecie punktu od pierwszego wyniku
    public void decrementScoreFirst() {
        if(scoreFirst>0) {
            scoreFirst -= 1;
        }
    }

    // dodanie punktu do drugiego wyniku
    public void incrementScoreSecond() {
        if(scoreSecond<99) {
            scoreSecond += 1;
        }
        displayCurrentScore();
    }

    // odjecie punktu od drugiego wyniku
    public void decrementScoreSecond() {
        if(scoreSecond>0) {
            scoreSecond -= 1;
        }
        displayCurrentScore();
    }

    //wypisanie wyniku dla pierwszej druzyny
    private void displayCurrentScore() {
        TextView scoreBoard = (TextView) findViewById(R.id.score_board);
        String valueToBoard = scoreFirst<9 ? "0"+scoreFirst : scoreFirst+"";
        valueToBoard += " : ";
        valueToBoard += scoreSecond<9 ? "0"+scoreSecond : scoreSecond+"";
    }
}
