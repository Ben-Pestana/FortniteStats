package com.hfad.fortnitestats;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HowToUse extends AppCompatActivity {

    private TextView howTo;
    private ImageView boogie;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        mp = MediaPlayer.create(this, R.raw.boogiebomb);

        wireWidgets();
        setOnCompletionListener();
        setOnClickListeners();
}

    private void setOnClickListeners() {
        boogie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
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

    private void wireWidgets() {
        howTo = findViewById(R.id.textView_howToUse_explanation);
        boogie = findViewById(R.id.imageView_howToUse_boogie);
    }


}
