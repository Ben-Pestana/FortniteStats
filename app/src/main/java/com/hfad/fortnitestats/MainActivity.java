package com.hfad.fortnitestats;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String epicUserHandle;
    private String accountId;
    private int platformId;
    private String platformName;
    private ArrayList<Stat> lifeTimeStats;
    private String temp;

    private MediaPlayer mp;

    private Button howTo;
    private Button search;
    private EditText username;
    private EditText console;

    public static final String EPICUSERHANDLE = "f";
    public static final String ACCOUNTID = "t";
    public static final String PLATFORMID = "s";
    public static final String PLATFORMNAME = "g";
    public static final String LIFETIMESTATS = "y";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setOnClickListeners();

        //TODO: Set if statements to check if username works or not and remove logs
    }

    private void setOnClickListeners() {
        howTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent howToUse = new Intent(MainActivity.this, HowToUse.class);
                startActivity(howToUse);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") && !console.getText().toString().equals("")) {
                    if (console.getText().toString().toLowerCase().equals("xbox") ||
                            console.getText().toString().toLowerCase().equals("pc") ||
                            console.getText().toString().toLowerCase().equals("ps4")) {
                        searchForPlayer();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Username or Console", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid Username or Console", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void searchForPlayer() {
        getAccountId(); // begins chain of getting everything
    }

    private void wireWidgets() {
        howTo = findViewById(R.id.button_main_howToUse);
        search = findViewById(R.id.button_main_search);
        username = findViewById(R.id.editText_main_username);
        console = findViewById(R.id.editText_main_console);

    }

    private void getEpicUserHandle() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FortniteTrackerNetwork service =
                retrofit.create(FortniteTrackerNetwork.class);

        //temporarily hardcode our food query
        //TODO make edittexts to enter the search terms
        Call<FortniteResponse> fortniteResponseCall =
                service.search(console.getText().toString().toLowerCase(), username.getText().toString());

        fortniteResponseCall.enqueue(new Callback<FortniteResponse>() {
            @Override
            public void onResponse(Call<FortniteResponse> call,
                                   Response<FortniteResponse> response) {
                epicUserHandle = response.body().getEpicUserHandle();
                getPlatFormId();
            }

            @Override
            public void onFailure(Call<FortniteResponse> call,
                                  Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });
    }

    private void getAccountId() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FortniteTrackerNetwork service =
                retrofit.create(FortniteTrackerNetwork.class);

        //temporarily hardcode our food query
        //TODO make edittexts to enter the search terms
        Call<FortniteResponse> fortniteResponseCall =
                service.search(console.getText().toString().toLowerCase(), username.getText().toString());

        fortniteResponseCall.enqueue(new Callback<FortniteResponse>() {
            @Override
            public void onResponse(Call<FortniteResponse> call,
                                   Response<FortniteResponse> response) {
                try {
                    accountId = response.body().getAccountId();
                    if (accountId == null){
                        Toast.makeText(MainActivity.this, "Invalid Username or Console", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        getEpicUserHandle();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Invalid Username or Console", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FortniteResponse> call,
                                  Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });

    }

    private void getPlatFormId() {
        // TODO convert this int to string for platform id if necessary
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FortniteTrackerNetwork service =
                retrofit.create(FortniteTrackerNetwork.class);

        //temporarily hardcode our food query
        //TODO make edittexts to enter the search terms


        Call<FortniteResponse> fortniteResponseCall =
                service.search(console.getText().toString().toLowerCase(), username.getText().toString());

        fortniteResponseCall.enqueue(new Callback<FortniteResponse>() {
            @Override
            public void onResponse(Call<FortniteResponse> call,
                                   Response<FortniteResponse> response) {
                try {
                    platformId = response.body().getPlatformId();
                    getPlatformName();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FortniteResponse> call,
                                  Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });

    }

    private void getPlatformName() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FortniteTrackerNetwork service =
                retrofit.create(FortniteTrackerNetwork.class);

        //temporarily hardcode our food query
        //TODO make edittexts to enter the search terms
        Call<FortniteResponse> fortniteResponseCall =
                service.search(console.getText().toString().toLowerCase(), username.getText().toString());

        fortniteResponseCall.enqueue(new Callback<FortniteResponse>() {
            @Override
            public void onResponse(Call<FortniteResponse> call,
                                   Response<FortniteResponse> response) {
                try{
                    platformName = response.body().getPlatformName();
                    getLifeTimeStats();
                }
                catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FortniteResponse> call,
                                  Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });
    }

    private void getLifeTimeStats() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FortniteTrackerNetwork service =
                retrofit.create(FortniteTrackerNetwork.class);

        //temporarily hardcode our food query
        //TODO make edittexts to enter the search terms
        Call<FortniteResponse> fortniteResponseCall =
                service.search(console.getText().toString().toLowerCase(), username.getText().toString());

        fortniteResponseCall.enqueue(new Callback<FortniteResponse>() {
            @Override
            public void onResponse(Call<FortniteResponse> call,
                                   Response<FortniteResponse> response) {
                lifeTimeStats = (ArrayList<Stat>) response.body().getLifeTimeStats();
                Intent goToStats = new Intent(MainActivity.this, StatsDisplay.class);
                goToStats.putExtra(EPICUSERHANDLE, epicUserHandle);
                goToStats.putExtra(ACCOUNTID, accountId);
                goToStats.putExtra(PLATFORMID, platformId);
                goToStats.putExtra(PLATFORMNAME, platformName);
                goToStats.putParcelableArrayListExtra(LIFETIMESTATS, lifeTimeStats);
                startActivity(goToStats);
            }

            @Override
            public void onFailure(Call<FortniteResponse> call,
                                  Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });
    }
}
