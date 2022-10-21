package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView wvWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wvWebView = findViewById(R.id.wvWebView);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        wvWebView.loadUrl(link);
        wvWebView.setWebViewClient(new WebViewClient());
    }
}