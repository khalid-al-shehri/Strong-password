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

public class MainActivityEn extends Activity implements View.OnClickListener {

    Button btn1En , btn2En , btn3En;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_en);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        btn1En = (Button) findViewById(R.id.btn1En);
        btn2En = (Button) findViewById(R.id.btn2En);
        btn3En = (Button) findViewById(R.id.btn3En);

        btn1En.setOnClickListener(this);
        btn2En.setOnClickListener(this);
        btn3En.setOnClickListener(this);

    }

    public void btn1En(){

        Intent GoRandomPageEn = new Intent(MainActivityEn.this,RandomPageEn.class);
        startActivity(GoRandomPageEn);
    }


    public void btn2En(){

        Intent GoPersonalPageEn = new Intent(MainActivityEn.this,Personal_Info_En.class);
        startActivity(GoPersonalPageEn);
    }


    public void btn3En(){

        Intent GoAboutUsPageEn = new Intent(MainActivityEn.this,About_UsEn.class);
        startActivity(GoAboutUsPageEn);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btn1En:
                btn1En();
                break;

            case R.id.btn2En:
                btn2En();
                break;

            case R.id.btn3En:
                btn3En();
                break;

                default:
                    break;

        }

    }
}
