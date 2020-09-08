package com.example.android.carromscorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int whiteButtonClicked = 0;
    int blackButtonClicked = 0;
    int teamWhiteScore = 0;
    int teamBlackScore = 0;
    int teamWhiteWins = 0;
    int teamBlackWins = 0;
    int purpleScore = 3;
    int isClicked = 0;
    String winningTeamWhite = "Team White Striker Wins";
    String winningTeamBlack = "Team Black Striker Wins";
    String noMoreBlackStriker = "There is no more black striker to score";
    String noMoreWhiteStriker = "There is no more white striker to score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // this is the method for displaying team black striker score textView
    public void score_display_team_black(int score) {
        TextView scoreView;
        scoreView = findViewById(R.id.score_team_black);
        scoreView.setText(String.valueOf(score));
    }

    // this is the method for displaying team white striker score textView
    public void score_display_team_white(int score) {
        TextView scoreView;
        scoreView = findViewById(R.id.score_team_white);
        scoreView.setText(String.valueOf(score));
    }

    // this is a method for displaying the winning team name and other info about when the striker reach the limit
    public void winning_display(String winning_text) {
        TextView winningText;
        winningText = findViewById(R.id.winner_text);
        winningText.setText(String.valueOf(winning_text));
    }

    // this is a method that increase the black striker counter and till when the black striker get to the limited number
    public void black_striker(View view) {
        if (teamBlackScore <= 24) {
            teamBlackScore = teamBlackScore + 1;
            score_display_team_black(teamBlackScore);
            blackButtonClicked = 1;
            didTeamWinn();
        } else winning_display(noMoreBlackStriker);

    }

    //this is the method for the purple striker (queen) counter
    // also it track if the purple striker button was clicked
    // and if it reach to the limit is disable the button
    // and track the black team when they click the purple striker
    public void purple_striker_TeamBlack(View view) {
        Button purpleStrikerBlack = findViewById(R.id.button_purple_striker_team_black);
        if (isClicked == 0) {
            teamBlackScore = teamBlackScore + purpleScore;
            score_display_team_black(teamBlackScore);
            isClicked = 1;
            teamBlackWins = 1;
        } else if (isClicked == 1) {
            purpleStrikerBlack.setEnabled(false);
        }
    }

    // this is a method that increase the white striker counter and till when the black striker get to the limited number
    public void white_striker(View view) {
        if (teamWhiteScore <= 24) {
            teamWhiteScore = teamWhiteScore + 1;
            score_display_team_white(teamWhiteScore);
            whiteButtonClicked = 1;
            didTeamWinn();
        } else winning_display(noMoreWhiteStriker);

    }

    //this is the method for the purple striker (queen) counter
    // also it track if the purple striker button was clicked
    // and if it reach to the limit is disable the button
    // and track the white team when they click the purple striker
    public void purple_striker_TeamWhite(View view) {
        Button purpleStrikerWhite = findViewById(R.id.button_purple_striker_team_white);
        if (isClicked == 0) {
            teamWhiteScore = teamWhiteScore + purpleScore;
            score_display_team_white(teamWhiteScore);
            isClicked = 1;
            teamWhiteWins = 1;
        } else if (isClicked == 1) {
            purpleStrikerWhite.setEnabled(false);
        }
    }

    // this method will monitor if a the team scored a purple striker then the same team color striker
    // if it did the team score stay the same
    // if it did not the team will lose the purple striker score
    // and it will reset all the values that help this method work
    public void didTeamWinn() {
        if (teamWhiteWins == 1 && blackButtonClicked == 1 && whiteButtonClicked == 0) {
            teamWhiteScore = teamWhiteScore - purpleScore;
            score_display_team_white(teamWhiteScore);
            isClicked = 0;
            teamWhiteWins = 0;
            teamBlackWins = 0;
            blackButtonClicked = 0;
            whiteButtonClicked = 0;
        } else if (teamBlackWins == 1 && whiteButtonClicked == 1 && blackButtonClicked == 0) {
            teamBlackScore = teamBlackScore - purpleScore;
            score_display_team_black(teamBlackScore);
            isClicked = 0;
            teamWhiteWins = 0;
            teamBlackWins = 0;
            blackButtonClicked = 0;
            whiteButtonClicked = 0;
        }
    }

    // this method reset all the values in the app
    // and determined what team won based on if the got the purple striker (queen)
    public void resetButton(View view) {
        if (teamBlackWins == 0 && teamWhiteWins == 0) {
            winning_display(" ");
            score_display_team_white(0);
            score_display_team_black(0);
            Button purpleStrikerBlack = findViewById(R.id.button_purple_striker_team_black);
            Button purpleStrikerWhite = findViewById(R.id.button_purple_striker_team_white);
            purpleStrikerBlack.setEnabled(true);
            purpleStrikerWhite.setEnabled(true);
            isClicked = 0;
            teamWhiteScore = 0;
            teamBlackScore = 0;
            teamBlackWins = 0;
            teamWhiteWins = 0;
            blackButtonClicked = 0;
            whiteButtonClicked = 0;
        } else if (teamBlackWins == 1) {
            winning_display(winningTeamBlack);
            score_display_team_white(0);
            score_display_team_black(0);
            Button purpleStrikerBlack = findViewById(R.id.button_purple_striker_team_black);
            Button purpleStrikerWhite = findViewById(R.id.button_purple_striker_team_white);
            purpleStrikerBlack.setEnabled(true);
            purpleStrikerWhite.setEnabled(true);
            isClicked = 0;
            teamWhiteScore = 0;
            teamBlackScore = 0;
            teamBlackWins = 0;
            teamWhiteWins = 0;
            blackButtonClicked = 0;
            whiteButtonClicked = 0;

        } else if (teamWhiteWins == 1) {
            winning_display(winningTeamWhite);
            score_display_team_white(0);
            score_display_team_black(0);
            Button purpleStrikerBlack = findViewById(R.id.button_purple_striker_team_black);
            Button purpleStrikerWhite = findViewById(R.id.button_purple_striker_team_white);
            purpleStrikerBlack.setEnabled(true);
            purpleStrikerWhite.setEnabled(true);
            isClicked = 0;
            teamWhiteScore = 0;
            teamBlackScore = 0;
            teamBlackWins = 0;
            teamWhiteWins = 0;
            blackButtonClicked = 0;
            whiteButtonClicked = 0;

        }
    }

}