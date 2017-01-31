package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPageAfterLogin extends AppCompatActivity {
    Button b4,b3,b2,b1,b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page_after_login);
        b1 = (Button)findViewById(R.id.mediaPlayerFirstPage);
        b2 = (Button)findViewById(R.id.calculatorFirstPage);
        b3 = (Button)findViewById(R.id.cameraFirstPage);
        b4 = (Button)findViewById(R.id.specialFunction);
        b5 = (Button)findViewById(R.id.firstPageLogout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMediaPlayer = new Intent(FirstPageAfterLogin.this, MediaPlayerPage.class);
                startActivity(toMediaPlayer);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCalculator = new Intent(FirstPageAfterLogin.this, Calculator.class);
                startActivity(toCalculator);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCamera = new Intent(FirstPageAfterLogin.this, Camera.class);
                startActivity(toCamera);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSpecialfunction = new Intent(FirstPageAfterLogin.this,MainActivity.class);
                startActivity(toSpecialfunction);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent firstPageToLogin = new Intent(FirstPageAfterLogin.this, Login.class);
                startActivity(firstPageToLogin);
                finish();
            }
        });
    }
}
