package com.example.android.pocketbutler;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


public class  Butler_webview extends AppCompatActivity {

    private WebView webView;

    private Button menuButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butler_webview);

        webView = findViewById(R.id.butler_view);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        if (getIntent().getStringExtra("content") != null) {
            Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();

        }

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        }

        else {
            // Loads the Butler server URL
            String url = ("https://ext-butler-server.kmt.orange.com/ButlerServer/welcome");
            webView.loadUrl(url);
        }

        menuButton = (Button) findViewById(R.id.menu_button);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }


    public void toMenu(View view) {
        Intent toMenu = new Intent(this, Menu.class);
        startActivity(toMenu);
    }

}
