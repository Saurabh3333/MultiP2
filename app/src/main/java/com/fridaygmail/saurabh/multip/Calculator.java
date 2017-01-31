package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    EditText e1,e2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1=(Button)findViewById(R.id.add);
        b2=(Button)findViewById(R.id.subtract);
        b3=(Button)findViewById(R.id.multiply);
        b4=(Button)findViewById(R.id.divide);
        b5=(Button)findViewById(R.id.reset);
        b6 = (Button)findViewById(R.id.backCalculator);
        e1=(EditText)findViewById(R.id.num1);
        e2=(EditText)findViewById(R.id.num2);
        t1=(TextView)findViewById(R.id.ans);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
               if(s1.equals("")||s2.equals("")) {
                    Toast.makeText(Calculator.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    float num1 = Float.parseFloat(s1);
                    float num2 = Float.parseFloat(s2);
                    float ans = num1+num2;
                    t1.setText(""+ans);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals("")) {
                    Toast.makeText(Calculator.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    float num1 = Float.parseFloat(s1);
                    float num2 = Float.parseFloat(s2);
                    float ans = num1-num2;
                    t1.setText(""+ans);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals("")) {
                    Toast.makeText(Calculator.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    float num1 = Float.parseFloat(s1);
                    float num2 = Float.parseFloat(s2);
                    float ans = num1*num2;
                    t1.setText(""+ans);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals("")) {
                    Toast.makeText(Calculator.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    float num1 = Float.parseFloat(s1);
                    float num2 = Float.parseFloat(s2);
                    if(num2==0.0){
                        Toast.makeText(Calculator.this, "A number can't be divided by zero", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        float ans = num1/num2;
                        t1.setText(""+ans);
                    }
                }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                e1.setText("");
                e2.setText("");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculatorToFirstPage = new Intent(Calculator.this, FirstPageAfterLogin.class);
                startActivity(calculatorToFirstPage);
                finish();
            }
        });
    }
}
