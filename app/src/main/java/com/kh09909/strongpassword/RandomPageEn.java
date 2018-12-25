package com.kh09909.strongpassword;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class RandomPageEn extends Activity implements View.OnClickListener {

    private AdView mAdView;

    TextView tv1En , tv2En;
    Button okbtnEn , copybtnEn;
    EditText et1En;
    CheckBox cb1En , cb2En , cb3En , cb4En;

    ClipboardManager ClipToCopy; // use it Copy Buttun
    ClipData clipString; // use it Copy Buttun

    int CheckEmpty = 0; // To check if the screen have value or not ((WE USE IT IN CHECK BUTTON AND PRINT))


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page_en);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        tv1En = (TextView) findViewById(R.id.tv1En);
        tv2En = (TextView) findViewById(R.id.tv2En);

        et1En = (EditText) findViewById(R.id.et1En);

        cb1En = (CheckBox) findViewById(R.id.cb1En);
        cb2En = (CheckBox) findViewById(R.id.cb2En);
        cb3En = (CheckBox) findViewById(R.id.cb3En);
        cb4En = (CheckBox) findViewById(R.id.cb4En);

        okbtnEn = (Button) findViewById(R.id.okbtnEn);
        copybtnEn = (Button) findViewById(R.id.cobybtnEn);

        okbtnEn.setOnClickListener(this);
        copybtnEn.setOnClickListener(this);

        ClipToCopy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

    }


    public String CL;
    public String SL;
    public String Num;
    public String SY;


    public String StrongPassword(int LP) // LP : Length Password
    {

        if (LP == 0) {
            Toast.makeText(getApplicationContext(), " You should change password length ", Toast.LENGTH_SHORT).show();
        }

        if (LP > 30 ){
            Toast.makeText(getApplicationContext(), " password length should less than 30 ", Toast.LENGTH_SHORT).show();
        }
        if(LP > 0 && LP <= 30) {
            CL = "";
            SL = "";
            Num = "";
            SY = "";



            if (cb1En.isChecked() && !cb2En.isChecked() && !cb3En.isChecked() && !cb4En.isChecked()) {
                Toast.makeText(getApplicationContext(), "Warning : this password NOT strong", Toast.LENGTH_SHORT).show();
            }
            if (!cb1En.isChecked() && cb2En.isChecked() && !cb3En.isChecked() && !cb4En.isChecked()) {
                Toast.makeText(getApplicationContext(), "Warning : this password NOT strong", Toast.LENGTH_SHORT).show();
            }
            if (!cb1En.isChecked() && !cb2En.isChecked() && cb3En.isChecked() && !cb4En.isChecked()) {
                Toast.makeText(getApplicationContext(), "Warning : this password NOT strong", Toast.LENGTH_SHORT).show();
            }
            if (!cb1En.isChecked() && !cb2En.isChecked() && !cb3En.isChecked() && cb4En.isChecked()) {
                Toast.makeText(getApplicationContext(), "Warning : this password NOT strong", Toast.LENGTH_SHORT).show();
            }
            if (!cb1En.isChecked() && !cb2En.isChecked() && !cb3En.isChecked() && !cb4En.isChecked()) {
                Toast.makeText(getApplicationContext(), " Choose from the list ", Toast.LENGTH_SHORT).show();
            }

            else{
                if (cb1En.isChecked()) {
                    CL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                }
                if (cb2En.isChecked()) {
                    SL = "abcdefghijklmnopqrstuvwxyz";
                }
                if (cb3En.isChecked()) {
                    Num = "0123456789";
                }
                if (cb4En.isChecked()) {
                    SY = "!@#$*_=+-/?";
                }


                String Mix = CL + SL + Num + SY;

                char[] chars = Mix.toCharArray();
                StringBuilder SB = new StringBuilder();
                Random random = new Random();
                for (int i = 0; i < LP; i++) {
                    char c = chars[random.nextInt(chars.length)];
                    SB.append(c);
                }
                tv1En.setText(SB);
                CopyPassword=SB.toString();
                CheckEmpty = 1;
                return SB.toString();

            }
        }
        return "";
    }

    public int Counter ;
    public int StartOrStopCopy = 1; // this variable to check the timer work or not , if it work we can't click on copy again

    public void TimerToDeleteCopy(){



        new CountDownTimer(60000,1000){
            public void onTick(long millisUntilFinished){
                tv2En.setText("Time remaining to delete : "+Counter);
                Counter++;


            }

            public void onFinish(){
                Counter=0;
                String copy = "No Password !!";
                clipString = ClipData.newPlainText("",copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(),"Done, Password deleted  ", Toast.LENGTH_SHORT).show();
                tv2En.setText("");
                StartOrStopCopy = 1;

            }

        }.start();


    }


    public void okbtnEn(){

        if (et1En.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), " You should enter password length ", Toast.LENGTH_SHORT).show();
        }
        else {
            StrongPassword(Integer.parseInt(et1En.getText().toString()));
        }
    }


    String CopyPassword;

    public void copybtnEn(){
        if(CheckEmpty>=1){
            if (StartOrStopCopy == 0){
                Toast.makeText(getApplicationContext()," Wait until 60 sec. finish ", Toast.LENGTH_SHORT).show();
            }
            else {
                Counter = 0;// When the user click copy again the timer will count again from zero
                tv2En.setText("Time remaining to delete : ");
                TimerToDeleteCopy();
                String copy = CopyPassword;
                clipString = ClipData.newPlainText("", copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(), "Copied , after 60 sec. the password will delete", Toast.LENGTH_SHORT).show();
                StartOrStopCopy = 0;
            }
        }

        else{
            Toast.makeText(getApplicationContext(),"You should get password to copy it ", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.okbtnEn:
                okbtnEn();
                break;

            case R.id.cobybtnEn:
                copybtnEn();
                break;

            default:
                break;
        }
    }
}
