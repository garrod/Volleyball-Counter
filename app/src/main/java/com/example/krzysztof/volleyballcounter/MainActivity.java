package com.example.krzysztof.volleyballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int scoreFirst = 0;
    public int scoreSecond = 0;
    public ImageView imageSetLeft;
    public ImageView imageSetRight;
    public TextView scoreBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSetLeft = (ImageView) findViewById(R.id.set_left);
        imageSetRight = (ImageView) findViewById(R.id.set_right);
        scoreBoard = (TextView) findViewById(R.id.score_board);
    }

    // dodanie punktu do pierwszego wyniku
    public void incrementScoreFirst(View view) {
        if(scoreFirst<99) {
            scoreFirst += 1;
        }
        System.out.println("scoreFirst : "+scoreFirst);

        imageSetLeft.setVisibility(View.VISIBLE);
        imageSetRight.setVisibility(View.INVISIBLE);

        displayCurrentScore();
    }

    // odjecie punktu od pierwszego wyniku
    public void decrementScoreFirst(View view) {
        if(scoreFirst>0) {
            scoreFirst -= 1;
        }
        displayCurrentScore();
    }

    // dodanie punktu do drugiego wyniku
    public void incrementScoreSecond(View view) {
        if(scoreSecond<99) {
            scoreSecond += 1;
        }

        imageSetLeft.setVisibility(View.INVISIBLE);
        imageSetRight.setVisibility(View.VISIBLE);

        displayCurrentScore();
    }

    // odjecie punktu od drugiego wyniku
    public void decrementScoreSecond(View view) {
        if(scoreSecond>0) {
            scoreSecond -= 1;
        }
        displayCurrentScore();
    }

    //wypisanie wyniku dla pierwszej druzyny
    private void displayCurrentScore() {
        scoreBoard = (TextView) findViewById(R.id.score_board);
        String valueToBoard = scoreFirst<10 ? "0"+scoreFirst : scoreFirst+"";
        valueToBoard += " : ";
        valueToBoard += scoreSecond<10 ? "0"+scoreSecond : scoreSecond+"";
        scoreBoard.setText(valueToBoard);
    }
}
