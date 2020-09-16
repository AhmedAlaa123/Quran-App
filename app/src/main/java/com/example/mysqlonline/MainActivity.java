package com.example.mysqlonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    private Button btnMoshaf, btnAzkar, btnAboutApp;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoshaf = findViewById(R.id.btnMoshaf);
        btnAzkar = findViewById(R.id.btnAzkar);
        btnAboutApp = findViewById(R.id.btnAboutApp);
        btnMoshaf.setOnClickListener(this);
        btnAboutApp.setOnClickListener(this);
        btnAzkar.setOnClickListener(this);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6423743720757224/8265617928");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }

   /* public void start(View view) {

        try {
            InputStream inputStream = getAssets().open("quranLinkes");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sounds.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            Random r = new Random();
            mediaPlayer.setDataSource(sounds.get(r.nextInt(114)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
مدنيه
    }*/


    @Override
    public void onClick(View v) {
        if (v.getId() == btnMoshaf.getId()) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Load the next interstitial.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        Intent intent = new Intent(MainActivity.this, MoshafActivity.class);
                        startActivity(intent);
                    }

                });

                //Toast.makeText(this,"loaded",Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, MoshafActivity.class);
                startActivity(intent);
            }


            //start moshaf activity
        } else if (v.getId() == btnAzkar.getId()) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Load the next interstitial.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
                        startActivity(intent);
                    }

                });
                //start azkar activity
            }
            else {
                Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
                startActivity(intent);
            }

        } else if (v.getId() == btnAboutApp.getId()) {
            //start about app activity
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Load the next interstitial.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        Intent intent = new Intent(MainActivity.this, AboutAppActivity.class);
                        startActivity(intent);
                    }

                });
                //start azkar activity
            }
            else {
                Intent intent = new Intent(MainActivity.this, AboutAppActivity.class);
                startActivity(intent);
            }
        }


    }
}