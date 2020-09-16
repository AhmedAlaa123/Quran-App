package com.example.mysqlonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AzkarActivity extends AppCompatActivity implements View.OnClickListener{
Button btnSbah,btnnoom,btnsalaht;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);
        btnsalaht=findViewById(R.id.btnsalaht);
        btnnoom=findViewById(R.id.btnnoom);
        btnSbah=findViewById(R.id.btnsbah);
        btnsalaht.setOnClickListener(this);
        btnSbah.setOnClickListener(this);
        btnnoom.setOnClickListener(this);
        mAdView = findViewById(R.id.adViewAzkarMenu);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6423743720757224/8265617928");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onClick(View v) {
       // Intent intent;

        if(btnSbah.getId()==v.getId())
        {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Load the next interstitial.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        Intent intent=new Intent(AzkarActivity.this,zikrcontent.class);
                        intent.putExtra("option","sbah");
                        startActivity(intent);
                    }

                });

                //Toast.makeText(this,"loaded",Toast.LENGTH_SHORT).show();
            } else {
                Intent   intent=new Intent(this,zikrcontent.class);
                intent.putExtra("option","sbah");
                startActivity(intent);;
            }

        }
        else if(btnnoom.getId()==v.getId())
        {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Load the next interstitial.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        Intent intent=new Intent(AzkarActivity.this,zikrcontent.class);
                        intent.putExtra("option","noom");
                        startActivity(intent);
                    }

                });

                //Toast.makeText(this,"loaded",Toast.LENGTH_SHORT).show();
            } else {
                Intent   intent=new Intent(this,zikrcontent.class);
                intent.putExtra("option","noom");
                startActivity(intent);;
            }


        }
        else if(btnsalaht.getId()==v.getId())
        {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Load the next interstitial.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        Intent intent=new Intent(AzkarActivity.this,zikrcontent.class);
                        intent.putExtra("option","salaht");
                        startActivity(intent);
                    }

                });

                //Toast.makeText(this,"loaded",Toast.LENGTH_SHORT).show();
            } else {
                Intent   intent=new Intent(this,zikrcontent.class);
                intent.putExtra("option","salaht");
                startActivity(intent);;
            }



        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                                              @Override
                                              public void onAdClosed() {
                                                  mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                                  // super.onAdClosed();
                                              }
                                          }

            );



        }
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                                              @Override
                                              public void onAdClosed() {
                                                  mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                                 // super.onAdClosed();
                                              }
                                          }

            );



        }
        finish();
        super.onBackPressed();
    }
    }

