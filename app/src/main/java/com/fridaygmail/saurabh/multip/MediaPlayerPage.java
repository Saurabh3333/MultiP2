package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaPlayerPage extends AppCompatActivity {
    Button b1,b2,b3,b4;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_page);
        b1=(Button)findViewById(R.id.play);
        b2=(Button)findViewById(R.id.pause);
        b3=(Button)findViewById(R.id.stop);
        b4 = (Button)findViewById(R.id.backCalculator);
        mp = MediaPlayer.create(MediaPlayerPage.this,R.raw.madaari);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mp.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mp.stop();
                mp = MediaPlayer.create(MediaPlayerPage.this,R.raw.madaari);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mediaPlayerToFirstPage = new Intent(MediaPlayerPage.this, FirstPageAfterLogin.class);
                startActivity(mediaPlayerToFirstPage);
                mp.stop();
                mp = MediaPlayer.create(MediaPlayerPage.this,R.raw.madaari);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        Intent toMainActivity = new Intent(MediaPlayerPage.this, FirstPageAfterLogin.class);
        startActivity(toMainActivity);
        finish();
    }
}
