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

public class Personal_Info extends Activity implements View.OnClickListener {

    EditText etName, etPhone, etDOB;
    TextView tvPI, tvTimer;
    CheckBox cb1PI;
    Button okbtnPI, copybtnPI;

    ClipboardManager ClipToCopy; // use it Copy Buttun
    ClipData clipString; // use it Copy Buttun

    int CheckEmpty = 0; // To check if the screen have value or not ((WE USE IT IN CHECK BUTTON AND PRINT))

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_personal__info);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        cb1PI = (CheckBox) findViewById(R.id.cb1PI);

        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etDOB = (EditText) findViewById(R.id.etDOB);

        tvPI = (TextView) findViewById(R.id.tvPI);
        tvTimer = (TextView) findViewById(R.id.tvTimer);

        okbtnPI = (Button) findViewById(R.id.okbtnPI);
        copybtnPI = (Button) findViewById(R.id.copybtnPI);

        okbtnPI.setOnClickListener(this);
        copybtnPI.setOnClickListener(this);

        ClipToCopy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


    }
//=====================================================================   MoreSecurity   =================================================================

    //----------------------------CAPITAL


    public String CapitalLetter() {

        String Mix1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars1 = Mix1.toCharArray();
        StringBuilder SBCapitalLetter = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            char c = chars1[random.nextInt(chars1.length)];
            SBCapitalLetter.append(c);
        }

        return SBCapitalLetter.toString();
    }


    //----------------------------Number

    public String Number(){

        String Mix1 = "0123456789";
        char[] chars1 = Mix1.toCharArray();
        StringBuilder SBNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            char c = chars1[random.nextInt(chars1.length)];
            SBNumber.append(c); }

        return SBNumber.toString();

    }

    //----------------------------Symbole

    public String Symbole(){

        String Mix1 = "!@#$*_=+-/?";
        char[] chars1 = Mix1.toCharArray();
        StringBuilder SBSymbole = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            char c = chars1[random.nextInt(chars1.length)];
            SBSymbole.append(c); }

        return SBSymbole.toString();

    }


    String MoreSecurity;
    public String MoreSecurity(){

        MoreSecurity = CapitalLetter()+ Number() + Symbole() ;

        return MoreSecurity;
    }

//=========================================================================================================================================================


//==========================================================================================================================================================

    //------------------------------------- NAME

    String Name;

    public String Name() {

        if (etName.length() > 20){
            Toast.makeText(getApplicationContext()," طول الاسم يجب أن يكون أقل من 20 حرف ", Toast.LENGTH_SHORT).show();
            etName.setText("");
        }

        if (etName.length() >= 3) {
            String Mix1 = etName.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBName = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                char c = chars1[i];
                SBName.append(c);
            }
            return SBName.toString();
        }

        if (etName.length() < 3) {
            String Mix1 = etName.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBName = new StringBuilder();
            for (int i = 0; i < etName.length(); i++) {
                char c = chars1[i];
                SBName.append(c);
            }
            return SBName.toString();
        }
        return "";
    }
    //-------------------------------------------------------

    //------------------------------------ Phone


    String Phone;

    public String Phone() {

        if (etPhone.length() > 15|| etPhone.length() < 4){
            Toast.makeText(getApplicationContext()," طول رقم الجوال يجب أن يكون أقل من 15 واكبر من 4 ", Toast.LENGTH_LONG).show();
            etPhone.setText("");
        }

        else {
            String Mix1 = etPhone.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBPhone = new StringBuilder();
            for (int i = etPhone.length() - 4; i < etPhone.length() ; i++) {
                char c = chars1[i];
                SBPhone.append(c);
            }
            return SBPhone.toString();
        }
        return "";
    }

    //--------------------------------------------------------

    //---------------------------------- DOB
    String DOB;

    public String DOB() {

        if (etDOB.length() < 4 || etDOB.length() > 4) {
            Toast.makeText(getApplicationContext()," الميلاد يجب أن يكون 4 ارقام ", Toast.LENGTH_SHORT).show();
            etDOB.setText("");
        }
        else {
            String Mix1 = etDOB.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBDOB = new StringBuilder();
            for (int i = 2; i < 4; i++) {
                char c = chars1[i];
                SBDOB.append(c);
            }
            return SBDOB.toString();
        }
        return "";
    }

    //--------------------------------------------------------

    //------------------------------------- INFORMATION



    String INFORMATION;
    public String INFORMATION(){

        return INFORMATION = Name() + Phone() + DOB();

    }
    //----------------------------------------------------------

//===================================================================================================================================================


    public String StrngPassword(){

        if(etName.getText().toString().equals("") || etPhone.getText().toString().equals("") || etDOB.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext()," أكمل أدخال المعلومات ", Toast.LENGTH_SHORT).show();
            tvPI.setText("");
        }



        else {
            if (cb1PI.isChecked()) {
                String CopyOfPassword = INFORMATION() + MoreSecurity();
                // This condation to check if all rules ok , if it ok show password if not don't show password
                if (etDOB.getText().toString().equals("") || etPhone.getText().toString().equals("") || etName.getText().toString().equals("")  ){
                    tvPI.setText("");
                }
                else {
                    tvPI.setText(CopyOfPassword);
                    CopyPassword = CopyOfPassword;
                    CheckEmpty = 1;
                }
            }
            else {
                String CopyOfPassword = (INFORMATION());
                // This condation to check if all rules ok , if it ok show password if not don't show password
                if (etDOB.getText().toString().equals("") || etPhone.getText().toString().equals("") || etName.getText().toString().equals("")  ){
                    tvPI.setText("");
                }
                else {
                    tvPI.setText(CopyOfPassword);
                    CopyPassword = CopyOfPassword;
                    CheckEmpty = 1;
                }
            }
        }
        return "";
    }


    //===================================================================================  COPY



    public int Counter ;
    public int StartOrStopCopy = 1; // this variable to check the timer work or not , if it work we can't click on copy again

    public void TimerToDeleteCopy(){



        new CountDownTimer(60000,1000){
            public void onTick(long millisUntilFinished){
                tvTimer.setText("الوقت المتبقي للحذف : "+Counter);
                Counter++;


            }

            public void onFinish(){
                Counter=0;
                String copy = "تم حذف كلمة السر !!";
                clipString = ClipData.newPlainText("",copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(),"تم حذف كلمة السر من الحافظة ", Toast.LENGTH_SHORT).show();
                tvTimer.setText("");
                StartOrStopCopy =1;

            }

        }.start();


    }

    String CopyPassword;

    public void copybtn(){
        if(CheckEmpty>=1) {
            if (StartOrStopCopy == 0) {
                Toast.makeText(getApplicationContext(), " أنتظر الى أن تنتهي 60 ثانية ", Toast.LENGTH_SHORT).show();
            }
            else {
                Counter = 0;// When the user click copy again the timer will count again from zero
                tvTimer.setText("الوقت المتبقي للحذف : ");
                TimerToDeleteCopy();
                String copy = CopyPassword;
                clipString = ClipData.newPlainText("", copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(), "تم النسخ ، بعد 60 ثانية سيتم الحذف من الحافظة ", Toast.LENGTH_SHORT).show();
                StartOrStopCopy = 0;
            }
        }

        else{
            Toast.makeText(getApplicationContext(),"لابد أن تحصل على كلمة سر أولا ", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {


            case R.id.okbtnPI:
                StrngPassword();
                break;

            case R.id.copybtnPI:
                copybtn();
                break;


            default:
                break;
        }
    }
}
