package com.example.mysqlonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AboutAppActivity extends AppCompatActivity {
TextView txtaboutApp;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        txtaboutApp=findViewById(R.id.textView2);
        txtaboutApp.setText("تطبيق حصن المسلم هو تطبيق خاص بالشاب والشابه المسلمه حيث البرنامج يحتوى مجموعه من الخدمات وهى :-\n" +
                "\n" +
                "\n" +
                "1-المصحف :-\n" +
                "  وحيث هذا المصحف يعمل عن طريق الانترنت حيث يقوم بتشغيل الاصوات من الانترنت\n" +
                "وهو بصوت القارىء احمد العجمى واستخدمنا هذه التقنيه لتصغير حجم البرنامج على الاجهزه.\n" +
                "\n" +
                "2-الازكار :-\n" +
                " وحيث هذا البرنامج يعرض مجموعه من الأزكار وهى :-\n" +
                "  -ازكار الصباح والمساء.\n" +
                "  -ازكار النوم.\n" +
                "  -ازكار بعد الصلاه.");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6423743720757224/8265617928");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mAdView = findViewById(R.id.adViewaboutapp);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                                              @Override
                                              public void onAdClosed() {
                                                  mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                                  //super.onAdClosed();
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
                                                  //super.onAdClosed();
                                              }
                                          }

            );



        }
        finish();
        super.onBackPressed();
    }
}
