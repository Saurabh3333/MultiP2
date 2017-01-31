package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {
    int response;
    int i, temp=0;
    static int right=0,wrong=0;
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    RadioGroup rb2;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        i = 1; temp=0; right = 0; wrong = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        b1 = (Button)findViewById(R.id.next);
        b2 = (Button)findViewById(R.id.submit);
        r1 = (RadioButton)findViewById(R.id.o1);
        r2 = (RadioButton)findViewById(R.id.o2);
        r3 = (RadioButton)findViewById(R.id.o3);
        r4 = (RadioButton)findViewById(R.id.o4);
        t1 = (TextView)findViewById(R.id.q);
        t2 = (TextView)findViewById(R.id.sno);
        rb2 = (RadioGroup)findViewById(R.id.radiogroup2);
        SQLiteDatabase sql = openOrCreateDatabase("multip",MODE_PRIVATE,null);
        sql.execSQL("create table if not exists questions (sno INTEGER PRIMARY KEY AUTOINCREMENT,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer INTEGER)");
        String s4 = "select * from questions where sno="+i+";";
        Cursor cursor = sql.rawQuery(s4,null);
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            t1.setText(cursor.getString(1));
            t2.setText(cursor.getString(0));
            r1.setText(cursor.getString(2));
            r2.setText(cursor.getString(3));
            r3.setText(cursor.getString(4));
            r4.setText(cursor.getString(5));

        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked() || r2.isChecked() || r3.isChecked() || r4.isChecked()) {
                    response = 0;
                    if (r1.isChecked()) {
                        response = 1;
                    } else if (r2.isChecked()) {
                        response = 2;
                    } else if (r3.isChecked()) {
                        response = 3;
                    } else if (r3.isChecked()) {
                        response = 4;
                    }
                    SQLiteDatabase sql = openOrCreateDatabase("multip", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists questions (sno INTEGER PRIMARY KEY AUTOINCREMENT,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer INTEGER)");
                    String s4 = "select * from questions where sno=" + i + ";";
                    Cursor cursor = sql.rawQuery(s4, null);


                    if (cursor.moveToNext()) {
                        int databaseAnswer = Integer.parseInt(cursor.getString(6));
                        if (response == databaseAnswer) {
                            rb2.clearCheck();
                            Toast.makeText(Questions.this, "Right answer", Toast.LENGTH_SHORT).show();
                            right++;
                            i++;
                        } else {
                            rb2.clearCheck();
                            Toast.makeText(Questions.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            wrong++;
                            i++;
                        }
                    } else if(temp!=1){
                        Toast.makeText(Questions.this, "Uncaught Exception", Toast.LENGTH_SHORT).show();
                    }


                    s4 = "select * from questions where sno=" + i + ";";
                    cursor = sql.rawQuery(s4, null);
                    if (cursor.moveToNext()) {
                        t1.setText(cursor.getString(1));
                        t2.setText(cursor.getString(0));
                        r1.setText(cursor.getString(2));
                        r2.setText(cursor.getString(3));
                        r3.setText(cursor.getString(4));
                        r4.setText(cursor.getString(5));

                    } else {
                        Toast.makeText(Questions.this, "Questions Ended", Toast.LENGTH_SHORT).show();
                        temp=1;
                    }
                }
                else if(temp==1){
                    Toast.makeText(Questions.this, "Questions Ended", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Questions.this, "Please provide your response.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Questions.this,ScoreCard.class);
                startActivity(k);
                finish();
            }
        });
    }
}
