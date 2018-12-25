package com.kh09909.strongpassword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class language extends Activity implements View.OnClickListener{


    Button enbtn , arbtn;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        enbtn = (Button) findViewById(R.id.englishbtn);
        arbtn = (Button) findViewById(R.id.arabicbtn);

        enbtn.setOnClickListener(this);
        arbtn.setOnClickListener(this);

    }

    public void arabicbtn(){
        Intent GoArabicPage = new Intent(language.this,MainActivity.class);
        startActivity(GoArabicPage);
    }
    public void englishbtn(){
        Intent GoEngishPage = new Intent(language.this,MainActivityEn.class);
        startActivity(GoEngishPage);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.arabicbtn:
                arabicbtn();
                break;

            case R.id.englishbtn:
                englishbtn();
                break;

                default:
                    break;
        }
        
    }
}
