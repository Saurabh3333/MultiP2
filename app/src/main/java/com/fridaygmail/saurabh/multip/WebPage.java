package com.fridaygmail.saurabh.multip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebPage extends AppCompatActivity {
    TextView t1;
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        t1 = (TextView)findViewById(R.id.webAddress);
        w1 = (WebView)findViewById(R.id.webPagewebView);
        t1.setText(ScoreCard.s);
        w1.setWebViewClient(new WebViewClient());
        w1.loadUrl(ScoreCard.s);

    }
}
