package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.*;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MagicalMusicPlayer extends AppCompatActivity implements SensorEventListener{
    Button b1;
    TextView t1;
    MediaPlayer mp;
    Sensor s;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical_music_player);
        b1 = (Button)findViewById(R.id.backMagical);
        t1 = (TextView)findViewById(R.id.sensorDisplay);
        mp = android.media.MediaPlayer.create(this,R.raw.champion);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent magicToMainActivity = new Intent(MagicalMusicPlayer.this, MainActivity.class);
                startActivity(magicToMainActivity);
                mp.stop();
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>5.000) {
            mp.start();
            float f = event.values[0];
            t1.setText("" + f);

        }
        else {
            float f = event.values[0];
            t1.setText(""+f);
            mp.pause();

        }

    }
    @Override
    public void onBackPressed() {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        Intent toMainActivity = new Intent(MagicalMusicPlayer.this, MainActivity.class);
        startActivity(toMainActivity);
        finish();
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
