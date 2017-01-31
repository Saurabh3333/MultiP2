package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.quizButton);
        b2 = (Button)findViewById(R.id.specialFunctionMagicalMusicPlayer);
        b3 = (Button)findViewById(R.id.backMainActivity);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuizMainPage.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMagicalMusicPlayer = new Intent(MainActivity.this, MagicalMusicPlayer.class);
                startActivity(toMagicalMusicPlayer);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainToFirstPage = new Intent(MainActivity.this, FirstPageAfterLogin.class);
                startActivity(mainToFirstPage);
                finish();
            }
        });
    }
}
