package com.hfad.fortnitestats;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StatsDisplay extends AppCompatActivity {

    public static final String TAG = StatsDisplay.class.getSimpleName();

    private String epicUserHandle;
    private String accountId;
    private int platformId;
    private String platformName;
    private ArrayList<Stat> lifeTimeStats;

    private TextView username;
    private TextView accountID;
    private TextView score;
    private TextView kdRatio;
    private TextView console;
    private TextView totalKills;
    private TextView totalMatches;

    private ImageView boogie;

    private MediaPlayer mp;

    public static final String LIFETIMESTATS = "y";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_display);

        mp = MediaPlayer.create(this, R.raw.boogiebomb);

        wireWidgets();
        recieveItems();
        setOnClickListeners();
        setOnCompletionListener();
        fillTextViews();
    }

    private void fillTextViews() {
        username.setText("Username: " + epicUserHandle);
        console.setText("Platform: " + platformName);
        score.setText("Score: " + lifeTimeStats.get(6).getValue());
        kdRatio.setText("K/D Ratio: " + lifeTimeStats.get(11).getValue());
        totalMatches.setText("Total Matches: " + lifeTimeStats.get(7).getValue());
        totalKills.setText("Total Kills: " + lifeTimeStats.get(10).getValue());
        accountID.setText("Account ID: " + accountId);
    }

    private void setOnClickListeners() {
        boogie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        totalMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent matchStats = new Intent(StatsDisplay.this, MatchStatsDisplay.class);
                matchStats.putParcelableArrayListExtra(LIFETIMESTATS, lifeTimeStats);
                startActivity(matchStats);
            }
        });
    }

    private void setOnCompletionListener() {
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                finish();
            }
        });
    }

    private void recieveItems() {
        Intent stats = getIntent();
        epicUserHandle = stats.getStringExtra(MainActivity.EPICUSERHANDLE);
        accountId = stats.getStringExtra(MainActivity.ACCOUNTID);
        platformId = stats.getIntExtra(MainActivity.PLATFORMID, 0);
        platformName = stats.getStringExtra(MainActivity.PLATFORMNAME);
        lifeTimeStats = stats.getParcelableArrayListExtra(MainActivity.LIFETIMESTATS);
        //Toast.makeText(this, lifetimeStats.get(0).getKey(), Toast.LENGTH_SHORT).show();
    }

    private void wireWidgets() {
        username = findViewById(R.id.textView_stats_username);
        accountID = findViewById(R.id.textView_stats_accountId);
        score = findViewById(R.id.textView_stats_score);
        kdRatio = findViewById(R.id.textView_stats_kdratio);
        console = findViewById(R.id.textView_stats_console);
        totalKills = findViewById(R.id.textView_stats_totalKills);
        totalMatches = findViewById(R.id.textView_stats_totalMatches);
        boogie = findViewById(R.id.imageView_stats_boogie);
    }
}
