package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionFeedMainPage extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3,e4,e5;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    int temp = 0 ,ans = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_feed_main_page);
        b1 = (Button)findViewById(R.id.submitQF);
        e1 = (EditText)findViewById(R.id.q);
        e2 = (EditText)findViewById(R.id.o1);
        e3 = (EditText)findViewById(R.id.o2);
        e4 = (EditText)findViewById(R.id.o3);
        e5 = (EditText)findViewById(R.id.o4);
        rg = (RadioGroup)findViewById(R.id.radioGroupFeed);
        rb1 = (RadioButton)findViewById(R.id.rightAnswer1);
        rb2 = (RadioButton)findViewById(R.id.rightAnswer2);
        rb3 = (RadioButton)findViewById(R.id.rightAnswer3);
        rb4 = (RadioButton)findViewById(R.id.rightAnswer4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 0; ans = 0;
                String q = e1.getText().toString();
                String o1 = e2.getText().toString();
                String o2 = e3.getText().toString();
                String o3 = e4.getText().toString();
                String o4 = e5.getText().toString();
                if(rb1.isChecked()) {temp++; ans = 1;}
                if(rb2.isChecked()) {temp++; ans = 2;}
                if(rb3.isChecked()) {temp++; ans = 3;}
                if(rb4.isChecked()) {temp++; ans = 4;}
                if(q.equals("") || o1.equals("") || o2.equals("") || o3.equals("") || o4.equals("")){
                    Toast.makeText(QuestionFeedMainPage.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(temp==0) {
                    Toast.makeText(QuestionFeedMainPage.this, "Please select the right answer.", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase sql = openOrCreateDatabase("multip",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists questions (sno INTEGER PRIMARY KEY AUTOINCREMENT,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer INTEGER)");
                    String s4 = "select * from questions where question='"+q+"'";
                    Cursor cursor = sql.rawQuery(s4,null);
                    if(cursor.getCount()>0){
                        Toast.makeText(QuestionFeedMainPage.this, "This question already exist", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        sql.execSQL("insert into questions (question,option1,option2,option3,option4,answer) values('"+q+"','"+o1+"','"+o2+"','"+o3+"','"+o4+"',"+ans+")");
                        Toast.makeText(QuestionFeedMainPage.this, "Question Added", Toast.LENGTH_SHORT).show();
                        e1.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");
                        e5.setText("");
                        rg.clearCheck();

                    }
                }
            }
        });
    }
}
