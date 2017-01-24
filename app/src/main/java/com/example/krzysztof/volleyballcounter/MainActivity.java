package com.example.krzysztof.volleyballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    public int scoreFirst = 0;
    public int scoreSecond = 0;
    public int currentSet = 0;
    public ImageView imageSetLeft;
    public ImageView imageSetRight;
    public TextView scoreBoard;

    public TextView[] resultsLeftArray;
    public TextView[] resultsRightArray;

    private TextView set1FirstTeam;
    private TextView set2FirstTeam;
    private TextView set3FirstTeam;
    private TextView set4FirstTeam;
    private TextView set5FirstTeam;

    private TextView set1SecondTeam;
    private TextView set2SecondTeam;
    private TextView set3SecondTeam;
    private TextView set4SecondTeam;
    private TextView set5SecondTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSetLeft = (ImageView) findViewById(R.id.set_left);
        imageSetRight = (ImageView) findViewById(R.id.set_right);
        scoreBoard = (TextView) findViewById(R.id.score_board);

        set1FirstTeam = (TextView) findViewById(R.id.set_1_first_team);
        set2FirstTeam = (TextView) findViewById(R.id.set_2_first_team);
        set3FirstTeam = (TextView) findViewById(R.id.set_3_first_team);
        set4FirstTeam = (TextView) findViewById(R.id.set_4_first_team);
        set5FirstTeam = (TextView) findViewById(R.id.set_5_first_team);

        set1SecondTeam = (TextView) findViewById(R.id.set_1_second_team);
        set2SecondTeam = (TextView) findViewById(R.id.set_2_second_team);
        set3SecondTeam = (TextView) findViewById(R.id.set_3_second_team);
        set4SecondTeam = (TextView) findViewById(R.id.set_4_second_team);
        set5SecondTeam = (TextView) findViewById(R.id.set_5_second_team);

        resultsLeftArray = new TextView[] {set1FirstTeam,set2FirstTeam,set3FirstTeam,set4FirstTeam,set5FirstTeam};
        resultsRightArray = new TextView[] {set1SecondTeam,set2SecondTeam,set3SecondTeam,set4SecondTeam,set5SecondTeam};
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

    public void finishSet(View view) {
        if(currentSet<5) {
            TextView leftScore = (TextView) resultsLeftArray[currentSet];
            TextView rightScore = (TextView) resultsRightArray[currentSet];

            leftScore.setText(scoreFirst<10 ? "0"+scoreFirst : scoreFirst+"");
            rightScore.setText(scoreSecond<10 ? "0"+scoreSecond : scoreSecond+"");

            scoreFirst = 0;
            scoreSecond = 0;
            currentSet += 1;

            displayCurrentScore();
        }
    }

    public void resetGame(View view) {
        currentSet = 0;
        scoreFirst = 0;
        scoreSecond = 0;

        TextView teamOneName = (TextView) findViewById(R.id.team_one_name);
        teamOneName.setText("");
        TextView teamTwoName = (TextView) findViewById(R.id.team_two_name);
        teamTwoName.setText("");

        for (TextView textObj : resultsLeftArray) {
            textObj.setText("00");
        }
        for (TextView textObj : resultsRightArray) {
            textObj.setText("00");
        }

        displayCurrentScore();
    }
}
