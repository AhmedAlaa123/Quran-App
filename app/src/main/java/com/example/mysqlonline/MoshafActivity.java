package com.example.mysqlonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MoshafActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    RecyclerView listsounds;
    ArrayList<surahData> sounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moshaf);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewMoshaf);
        listsounds = findViewById(R.id.listSounds);
        sounds = new ArrayList<>();
        loadData();
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6423743720757224/8265617928");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



                Adapter adapter = new Adapter(sounds,this);
                listsounds.setLayoutManager(new LinearLayoutManager(this));
                listsounds.setAdapter(adapter);




    }

    @Override
    public boolean onSupportNavigateUp() {
      //  Toast.makeText(this,"back Clicked",Toast.LENGTH_SHORT).show();
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
            Adapter.mediaPlayer.release();
            finish();
          //  super.onBackPressed();

        }else {
            Adapter.mediaPlayer.release();
            finish();
            super.onBackPressed();
        }
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
            Adapter.mediaPlayer.release();
            finish();
            super.onBackPressed();

        }else {
            Adapter.mediaPlayer.release();
            finish();
            super.onBackPressed();
        }
    }

    private void loadData() {
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/001.mp3 ", "الفاتحه", "مكيه", 7));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/002.mp3 ", "البقره", "مدنيه", 286));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/003.mp3 ", "ال عمران", "مدنيه", 200));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/004.mp3 ", "النساء", "مدنيه", 176));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/005.mp3 ", "المائده", "مدنيه", 120));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/006.mp3 ", "الانعام", "مكيه", 165));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/007.mp3 ", "الاعراف", "مكيه", 206));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/008.mp3 ", "الانفال", "مدنيه", 75));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/009.mp3 ", "التوبه", "مدنيه", 129));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/0010.mp3 ", "يونس", "مكيه", 109));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/011.mp3 ", "هود", "مكيه", 123));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/012.mp3 ", "يوسف", "مكيه", 111));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/013.mp3 ", "الرعد", "مدنيه", 43));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/014.mp3 ", "ابراهيم", "مكيه", 52));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/015.mp3 ", "الحجر", "مكيه", 99));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/016.mp3 ", "النحل", "مكيه", 128));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/017.mp3 ", "الاسراء", "مكيه", 111));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/018.mp3 ", "الكهف", "مكيه", 110));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/019.mp3 ", "مريم", "مكيه", 98));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/020.mp3 ", "طه", "مكيه", 135));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/021.mp3 ", "الانبياء", "مكيه", 112));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/022.mp3 ", "الحج", "مدنيه", 78));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/023.mp3 ", "المؤمنون", "مكيه", 118));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/024.mp3 ", "النور", "مدنيه", 64));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/025.mp3 ", "الفرقان", "مكيه", 77));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/026.mp3 ", "الشعراء", "مكيه", 227));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/027.mp3 ", "النمل", "مكيه", 93));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/028.mp3 ", "القصص", "مكيه", 88));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/029.mp3 ", "العنكبوت", "مكيه", 69));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/030.mp3 ", "الروم", "مكيه", 60));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/031.mp3 ", "لقمان", "مكيه", 34));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/032.mp3 ", "السجده", "مكيه", 30));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/033.mp3 ", "الاحزاب", "مدنيه", 73));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/034.mp3 ", "سبأ", "مكيه", 54));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/035.mp3 ", "فاطر", "مكيه", 45));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/036.mp3 ", "يٍس", "مكيه", 83));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/037.mp3 ", "الصافات", "مكيه", 182));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/038.mp3 ", "صً", "مكيه", 88));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/039.mp3 ", "الزمر", "مكيه", 75));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/040.mp3 ", "غافر", "مكيه", 85));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/041.mp3 ", "فصًلت", "مكيه", 54));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/042.mp3 ", "الشٌورى", "مكيه", 53));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/043.mp3 ", "الزخرف", "مكيه", 89));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/044.mp3 ", "الدخان", "مكيه", 59));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/045.mp3 ", "الجاثيه", "مكيه", 37));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/046.mp3 ", "الاحقاف", "مكيه", 35));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/047.mp3 ", "محمد", "مدنيه", 38));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/048.mp3 ", "الفتح", "مدنيه", 29));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/049.mp3 ", "الحجرات", "مدنيه", 18));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/050.mp3 ", "ق", "مكيه", 45));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/051.mp3 ", "الزاريات", "مكيه", 60));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/052.mp3 ", "الطور", "مكيه", 49));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/053.mp3 ", "النجم", "مكيه", 62));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/054.mp3 ", "القمر", "مكيه", 55));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/055.mp3 ", "الرحمن", "مدنيه", 78));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/056.mp3 ", "الواقعه", "مكيه", 96));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/057.mp3 ", "الحديد", "مدنيه", 29));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/058.mp3 ", "المجادله", "مدنيه", 22));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/059.mp3 ", "الحشر", "مدنيه", 24));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/060.mp3 ", "الممتحنه", "مدنيه", 13));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/061.mp3 ", "الصف", "مدنيه", 14));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/062.mp3 ", "الجمعه", "مدنيه", 11));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/063.mp3 ", "المنافقون", "مدنيه", 11));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/064.mp3 ", "التغابن", "مدنيه", 18));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/065.mp3 ", "الطلاق", "مدنيه", 12));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/066.mp3 ", "التحريم", "مدنيه", 12));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/067.mp3 ", "الملك", "مكيه", 30));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/068.mp3 ", "القلم", "مكيه", 52));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/069.mp3 ", "الحاقه", "مكيه", 52));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/070.mp3 ", "المعارج", "مكيه", 44));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/071.mp3 ", "نوح", "مكيه", 28));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/072.mp3 ", "الجن", "مكيه", 28));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/073.mp3 ", "المزمل", "مكيه", 20));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/074.mp3 ", "المدثر", "مكيه", 56));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/075.mp3 ", "القيامه", "مكيه", 40));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/076.mp3 ", "الانسان", "مدنيه", 31));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/077.mp3 ", "المرسلات", "مكيه", 50));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/078.mp3 ", "النبأ", "مكيه", 40));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/079.mp3 ", "النازعات", "مكيه", 46));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/080.mp3 ", "عبس", "مكيه", 42));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/081.mp3 ", "التكوير", "مكيه", 29));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/082.mp3 ", "الانفطار", "مكيه", 19));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/083.mp3 ", "المطففين", "مكيه", 36));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/084.mp3 ", "الانشقاق", "مكيه", 25));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/085.mp3 ", "البروج", "مكيه", 22));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/086.mp3 ", "الطارق", "مكيه", 17));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/087.mp3 ", "الاعلى", "مكيه", 19));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/088.mp3 ", "الغاشيه", "مكيه", 26));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/089.mp3 ", "الفجر", "مكيه", 30));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/090.mp3 ", "البلد", "مكيه", 20));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/091.mp3 ", "الشمس", "مكيه", 15));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/092.mp3 ", "الليل", "مكيه", 21));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/093.mp3 ", "الضحى", "مكيه", 11));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/094.mp3 ", "الشرح", "مكيه", 8));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/095.mp3 ", "التين", "مكيه", 8));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/096.mp3 ", "العلق", "مكيه", 19));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/097.mp3 ", "القدر", "مكيه", 5));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/098.mp3 ", "البينه", "مدنيه", 8));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/099.mp3 ", "الزلزله", "مدنيه", 8));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/100.mp3 ", "العاديات", "مكيه", 11));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/101.mp3 ", "القارعه", "مكيه", 11));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/102.mp3 ", "التكاثر", "مكيه", 8));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/103.mp3 ", "العصر", "مكيه", 3));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/104.mp3 ", "الهمزه", "مكيه", 9));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/105.mp3 ", "الفيل", "مكيه", 5));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/106.mp3 ", "قريش", "مكيه", 4));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/107.mp3 ", "الماعون", "مكيه", 7));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/108.mp3 ", "الكوثر", "مكيه", 3));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/109.mp3 ", "الكافرون", "مكيه", 6));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/110.mp3 ", "النصر", "مدنيه", 3));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/111.mp3 ", "المسد", "مكيه", 5));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/112.mp3 ", "الاخلاص", "مكيه", 4));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/113.mp3 ", "الفلق", "مكيه", 5));
        sounds.add(new surahData("http://cdnserver10.mp3quran.net/ajm/128/114.mp3 ", "الناس", "مكيه", 6));


    }
}

