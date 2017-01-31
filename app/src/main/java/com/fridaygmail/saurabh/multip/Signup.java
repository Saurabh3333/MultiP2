package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    EditText fName,lName,cpassword,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        b1 = (Button)findViewById(R.id.signupSignup);
        b2 = (Button)findViewById(R.id.signupLogin);
        e1 = (EditText)findViewById(R.id.signupUsername);
        e2 = (EditText)findViewById(R.id.signupPassword);
        e3 = (EditText)findViewById(R.id.signupEmail);
        fName = (EditText)findViewById(R.id.firstName);
        lName = (EditText)findViewById(R.id.lastName);
        cpassword = (EditText)findViewById(R.id.signupConfirmPassword);
        mobile = (EditText)findViewById(R.id.mobilenumber);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString(); // Username
                String s2 = e2.getText().toString(); // Password
                String s3 = e3.getText().toString();  //  Email
                String m4 = fName.getText().toString(); // First Name
                String m5 = lName.getText().toString(); // Last Name
                String m6 = cpassword.getText().toString(); // C Password
                String m7 = mobile.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || m4.equals("") || m5.equals("") || m6.equals("") || m7.equals("")) {
                    Toast.makeText(Signup.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(!s2.equals(m6)){
                    Toast.makeText(Signup.this, "Password and confirm password don't matches", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase sql = openOrCreateDatabase("multip", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists loginInfo (name varchar,password varchar,email varchar)");
                    String s4 = "select * from loginInfo where name='" + s1 + "'";
                    Cursor cursor = sql.rawQuery(s4, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(Signup.this, "User already exist", Toast.LENGTH_SHORT).show();
                    } else {
                        sql.execSQL("insert into loginInfo values ('" + s1 + "','" + s2 + "','" + s3 + "')");
                        Toast.makeText(Signup.this, "Signup Successfull", Toast.LENGTH_SHORT).show();
                        Intent signupToLogin = new Intent(Signup.this, Login.class);
                        startActivity(signupToLogin);
                        finish();
                    }
                }
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(Signup.this, Login.class);
                startActivity(toLogin);
                finish();
            }
        });

    }
}
