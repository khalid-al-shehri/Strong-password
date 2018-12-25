package com.kh09909.strongpassword;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class About_Us extends Activity implements View.OnClickListener {


    Button Twibtn , Emailbtn;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about__us);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Twibtn = (Button) findViewById(R.id.Twibtn);
        Emailbtn = (Button) findViewById(R.id.Emailbtn);

        Twibtn.setOnClickListener(this);
        Emailbtn.setOnClickListener(this);

    }

    public void Twibtn(){

        Uri uri = Uri.parse("https://twitter.com/khl0od"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void Emailbtn(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "kh09909@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(intent, ""));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.Twibtn:
                Twibtn();
                break;

            case R.id.Emailbtn:
                Emailbtn();
                break;

            default:
                break;
        }

    }
}
