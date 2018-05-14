package com.example.android.pocketbutler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by jskx3431 on 24/04/2018.
 */

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private ImageButton scanButton;

    private Button httpTestButton;

    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        scanButton = findViewById(R.id.scan_button);
        //attaching onclick listener
        scanButton.setOnClickListener(this);

        httpTestButton = findViewById(R.id.request_test);
        //attaching onclick listener
        httpTestButton.setOnClickListener(this);


        qrScan = new IntentIntegrator(this);
    }

    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }

    public void httpRequest(View view){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result !=null ) {
            result.getContents();
            //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, Butler_webview.class);
            intent.putExtra("content", result.getContents());
            startActivity(intent);
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}
