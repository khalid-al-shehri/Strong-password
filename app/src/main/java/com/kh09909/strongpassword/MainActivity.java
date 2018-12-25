package com.kh09909.strongpassword;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn1, btn2, btn3;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }

    public void btn1(){
        Intent GoRandomPage = new Intent(MainActivity.this,RandomPage.class);
        startActivity(GoRandomPage);
    }

    public void btn2(){
        Intent GoPersonalInfoPage = new Intent(MainActivity.this,Personal_Info.class);
        startActivity(GoPersonalInfoPage);
    }

    public void btn3(){
        Intent GoAboutUsPage = new Intent(MainActivity.this,About_Us.class);
        startActivity(GoAboutUsPage);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.btn1:
                btn1();
                break;

            case R.id.btn2:
                btn2();
                break;

            case R.id.btn3:
                btn3();
                break;

            default:
                break;
        }

    }
}
