package com.kh09909.strongpassword;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
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

public class RandomPage extends Activity implements View.OnClickListener {

    private AdView mAdView;

    CheckBox cb1, cb2, cb3, cb4;
    TextView tv1,tv2;
    EditText et1;
    Button okbtn, copybtn;
    ClipboardManager ClipToCopy; // use it Copy Buttun
    ClipData clipString; // use it Copy Buttun

    int CheckEmpty = 0; // To check if the screen have value or not ((WE USE IT IN CHECK BUTTON AND PRINT))

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_random_page);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);

        et1 = (EditText) findViewById(R.id.et1En);
        et1.equals("0");

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        okbtn = (Button) findViewById(R.id.okbtn);
        copybtn = (Button) findViewById(R.id.cobybtn);

        okbtn.setOnClickListener(this);
        copybtn.setOnClickListener(this);

        ClipToCopy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


    }




    public String CL;
    public String SL;
    public String Num;
    public String SY;


    public String StrongPassword(int LP) // LP : Length Password
    {

        if (LP == 0) {
            Toast.makeText(getApplicationContext(), "  لابد من إدخال طول كلمة سر مختلف   ", Toast.LENGTH_SHORT).show();
        }

        if (LP > 30 ){
            Toast.makeText(getApplicationContext(), "  لابد أن يكون طول كلمة السر اصغر من 30   ", Toast.LENGTH_SHORT).show();
        }
        if(LP > 0 && LP <= 30) {
            CL = "";
            SL = "";
            Num = "";
            SY = "";


            if (cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                Toast.makeText(getApplicationContext(), " تنبيه : كلمة السر هذه ليست أمنة بشكل كافي ", Toast.LENGTH_SHORT).show();
            }
            if (!cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                Toast.makeText(getApplicationContext(), " تنبيه : كلمة السر هذه ليست أمنة بشكل كافي ", Toast.LENGTH_SHORT).show();
            }
            if (!cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()) {
                Toast.makeText(getApplicationContext(), " تنبيه : كلمة السر هذه ليست أمنة بشكل كافي ", Toast.LENGTH_SHORT).show();
            }
            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()) {
                Toast.makeText(getApplicationContext(), " تنبيه : كلمة السر هذه ليست أمنة بشكل كافي ", Toast.LENGTH_SHORT).show();
            }

            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                Toast.makeText(getApplicationContext(), "  أختار من القائمة  ", Toast.LENGTH_SHORT).show();
            }

            else{
                if (cb1.isChecked()) {
                    CL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                }
                if (cb2.isChecked()) {
                    SL = "abcdefghijklmnopqrstuvwxyz";
                }
                if (cb3.isChecked()) {
                    Num = "0123456789";
                }
                if (cb4.isChecked()) {
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
                tv1.setText(SB);
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
                tv2.setText("الوقت المتبقي للحذف : "+Counter);
                Counter++;


            }

            public void onFinish(){
                Counter=0;
                String copy = "تم حذف كلمة السر !!";
                clipString = ClipData.newPlainText("",copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(),"تم حذف كلمة السر من الحافظة", Toast.LENGTH_SHORT).show();
                tv2.setText("");
                StartOrStopCopy = 1;

            }

        }.start();


    }


    public void okbtn(){

        if (et1.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "  يجب إدخال طول لكلمة السر   ", Toast.LENGTH_SHORT).show();
        }
        else {
            StrongPassword(Integer.parseInt(et1.getText().toString()));
        }
    }


    String CopyPassword;

    public void copybtn(){
        if(CheckEmpty>=1){
            if (StartOrStopCopy == 0){
                Toast.makeText(getApplicationContext()," أنتظر الى أن تنتهي 60 ثانية ", Toast.LENGTH_SHORT).show();
            }
            else {
                Counter = 0;// When the user click copy again the timer will count again from zero
                tv2.setText("الوقت المتبقي للحذف : ");
                TimerToDeleteCopy();
                String copy = CopyPassword;
                clipString = ClipData.newPlainText("", copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(), "تم النسخ ، بعد 60 ثانية سيتم الحذف من الحافظة", Toast.LENGTH_SHORT).show();
                StartOrStopCopy = 0;
            }
        }

        else{
            Toast.makeText(getApplicationContext()," لابد أن تحصل على كلمة سر أولا ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.okbtn:
                okbtn();
                break;

            case R.id.cobybtn:
                copybtn();
                break;

                default:
                    break;
        }
    }
}

