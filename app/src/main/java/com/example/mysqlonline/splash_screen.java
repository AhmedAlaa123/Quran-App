package com.example.mysqlonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class splash_screen extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        new Thread() {
            @Override
            public void run() {
                for (int step = 0; step < 100; step++) {
                    progressBar.setProgress(step);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        }.start();
    }
}
