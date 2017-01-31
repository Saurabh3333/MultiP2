package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = (Button)findViewById(R.id.loginLogin);
        b2 = (Button)findViewById(R.id.loginSignup);
        e1 = (EditText)findViewById(R.id.loginUsername);
        e2 = (EditText)findViewById(R.id.loginPassword);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(Login.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase sql = openOrCreateDatabase("multip",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists loginInfo (name varchar,password varchar,email varchar)");
                    String s3 = "select * from loginInfo where (name='"+s1+"'and password='"+s2+"')";
                    Cursor cursor = sql.rawQuery(s3,null);
                    if (cursor.getCount()>0){
                        Toast.makeText(Login.this, "Hello "+s1, Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(Login.this, FirstPageAfterLogin.class);
                        startActivity(j);
                        finish();
                    }
                    else {
                        Toast.makeText(Login.this, "You are not registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToSignup = new Intent(Login.this,Signup.class);
                startActivity(loginToSignup);
                finish();
            }
        });
    }
}
