package com.kh09909.strongpassword;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class About_UsEn extends Activity implements View.OnClickListener {


    Button TwibtnEn , EmailbtnEn;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us_en);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        TwibtnEn = (Button) findViewById(R.id.TwibtnEn);
        EmailbtnEn = (Button) findViewById(R.id.EmailbtnEn);

        TwibtnEn.setOnClickListener(this);
        EmailbtnEn.setOnClickListener(this);

    }

    public void TwibtnEn(){

        Uri uri = Uri.parse("https://twitter.com/khl0od"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void EmailbtnEn(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "kh09909@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(intent, ""));

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.TwibtnEn:
                TwibtnEn();
                break;

            case R.id.EmailbtnEn:
            EmailbtnEn();
            break;

            default:
                break;
        }


    }
}
