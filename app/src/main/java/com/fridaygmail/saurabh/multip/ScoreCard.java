package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreCard extends AppCompatActivity {
    TextView t1;
    Button b1,b2,b3,b4;
    static String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        s ="";
        t1 = (TextView)findViewById(R.id.score);
        int total = 10*Questions.right-5*Questions.wrong;
        t1.setText("Your score is: "+ total);
        b1 = (Button)findViewById(R.id.facebook);
        b2 = (Button)findViewById(R.id.twitter);
        b3 = (Button)findViewById(R.id.netcamp);
        b4 = (Button)findViewById(R.id.homeWeb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "http://www.facebook.com";
                Intent ak47 = new Intent(ScoreCard.this,WebPage.class);
                startActivity(ak47);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "http://www.twitter.com";
                Intent ak47 = new Intent(ScoreCard.this,WebPage.class);
                startActivity(ak47);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "http://www.netcamp.in";
                Intent ak47 = new Intent(ScoreCard.this,WebPage.class);
                startActivity(ak47);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreToHome = new Intent(ScoreCard.this,FirstPageAfterLogin.class);
                startActivity(scoreToHome);
            }
        });
    }
}
