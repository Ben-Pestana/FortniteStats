package com.hfad.fortnitestats;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchStatsDisplay extends AppCompatActivity {

    private TextView wins;
    private TextView winRatio;
    private TextView topThree;
    private TextView topFive;
    private TextView topSix;
    private TextView topTen;
    private TextView totalMatches;

    private MediaPlayer mp;

    private ArrayList<Stat> lifeTimeStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_stats_display);

        mp = MediaPlayer.create(this, R.raw.boogiebomb);

        wireWidgets();
        setOnClickListeners();
        recieveItems();
        fillTextViews();

    }

    private void fillTextViews() {
        wins.setText("Wins: " + lifeTimeStats.get(8).getValue());
        winRatio.setText("Win Ratio: " + lifeTimeStats.get(9).getValue());
        topThree.setText("Top Three: " + lifeTimeStats.get(1).getValue());
        topFive.setText("Top Five: " + lifeTimeStats.get(0).getValue());
        topSix.setText("Top Six: " + lifeTimeStats.get(2).getValue());
        topTen.setText("Top Ten: " + lifeTimeStats.get(3).getValue());
        totalMatches.setText("Total Matches: " + lifeTimeStats.get(7).getValue());
        //TODO: Finish filling textViews
    }

    private void setOnClickListeners() {
        totalMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void recieveItems() {
        Intent stats = getIntent();
        lifeTimeStats = stats.getParcelableArrayListExtra(StatsDisplay.LIFETIMESTATS);
    }

    private void wireWidgets() {
        wins = findViewById(R.id.textView_matches_wins);
        winRatio = findViewById(R.id.textView_matches_winratio);
        topThree = findViewById(R.id.textView_matches_top3);
        topFive = findViewById(R.id.textView_matches_top5);
        topSix = findViewById(R.id.textView_matches_top6);
        topTen = findViewById(R.id.textView_matches_top10);
        totalMatches =  findViewById(R.id.textView_matches_totalMatches);

    }
}
