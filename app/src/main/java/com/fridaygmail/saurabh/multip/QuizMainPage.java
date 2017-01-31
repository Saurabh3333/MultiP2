package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizMainPage extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main_page);
        b1 = (Button)findViewById(R.id.feedQuestions);
        b2 = (Button)findViewById(R.id.startQuiz);
        b3 = (Button)findViewById(R.id.backQuizMainPage);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(QuizMainPage.this, QuestionFeedMainPage.class);
                startActivity(j);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(QuizMainPage.this, Questions.class);
                startActivity(j);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quizMainPageToMainActvity = new Intent(QuizMainPage.this, MainActivity.class);
                startActivity(quizMainPageToMainActvity);
                finish();
            }
        });

    }
}
