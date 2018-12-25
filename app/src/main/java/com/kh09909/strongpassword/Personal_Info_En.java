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

public class Personal_Info_En extends Activity implements View.OnClickListener{

    EditText etNameEn, etPhoneEn, etDOBEn;
    TextView tvPIEn, tvTimerEn;
    CheckBox cb1PIEn;
    Button okbtnPIEn, copybtnPIEn;

    ClipboardManager ClipToCopy; // use it Copy Buttun
    ClipData clipString; // use it Copy Buttun

    int CheckEmpty = 0; // To check if the screen have value or not ((WE USE IT IN CHECK BUTTON AND PRINT))

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__info__en);

        MobileAds.initialize(this, "ca-app-pub-9554171393741373/6340763489");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9554171393741373/6340763489");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        cb1PIEn = (CheckBox) findViewById(R.id.cb1PIen);

        etNameEn = (EditText) findViewById(R.id.etNameen);
        etPhoneEn = (EditText) findViewById(R.id.etPhoneen);
        etDOBEn = (EditText) findViewById(R.id.etDOBen);

        tvPIEn = (TextView) findViewById(R.id.tvPIen);
        tvTimerEn = (TextView) findViewById(R.id.tvTimeren);

        okbtnPIEn = (Button) findViewById(R.id.okbtnPIen);
        copybtnPIEn = (Button) findViewById(R.id.copybtnPIen);

        okbtnPIEn.setOnClickListener(this);
        copybtnPIEn.setOnClickListener(this);

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

        if (etNameEn.length() > 20){
            Toast.makeText(getApplicationContext()," The name length should be less then 20 letter ", Toast.LENGTH_SHORT).show();
            etNameEn.setText("");
        }

        if (etNameEn.length() >= 3) {
            String Mix1 = etNameEn.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBName = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                char c = chars1[i];
                SBName.append(c);
            }
            return SBName.toString();
        }

        if (etNameEn.length() < 3) {
            String Mix1 = etNameEn.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBName = new StringBuilder();
            for (int i = 0; i < etNameEn.length(); i++) {
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

        if (etPhoneEn.length() > 15|| etPhoneEn.length() < 4){
            Toast.makeText(getApplicationContext()," Phone number length should be between 15 and 4 boxes", Toast.LENGTH_LONG).show();
            etPhoneEn.setText("");
        }

        else {
            String Mix1 = etPhoneEn.getText().toString();
            char[] chars1 = Mix1.toCharArray();
            StringBuilder SBPhone = new StringBuilder();
            for (int i = etPhoneEn.length() - 4; i < etPhoneEn.length() ; i++) {
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

        if (etDOBEn.length() < 4 || etDOBEn.length() > 4) {
            Toast.makeText(getApplicationContext()," Date of birth should equal 4 boxes ", Toast.LENGTH_SHORT).show();
            etDOBEn.setText("");
        }
        else {
            String Mix1 = etDOBEn.getText().toString();
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

        if(etNameEn.getText().toString().equals("") || etPhoneEn.getText().toString().equals("") || etDOBEn.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext()," Fill the blanks", Toast.LENGTH_SHORT).show();
            tvPIEn.setText("");
        }



        else {
            if (cb1PIEn.isChecked()) {
                String CopyOfPassword = INFORMATION() + MoreSecurity();
                // This condation to check if all rules ok , if it ok show password if not don't show password
                if (etDOBEn.getText().toString().equals("") || etPhoneEn.getText().toString().equals("") || etNameEn.getText().toString().equals("")  ){
                    tvPIEn.setText("");
                }
                else {
                    tvPIEn.setText(CopyOfPassword);
                    CopyPassword = CopyOfPassword;
                    CheckEmpty = 1;
                }
            }
            else {
                String CopyOfPassword = (INFORMATION());
                // This condation to check if all rules ok , if it ok show password if not don't show password
                if (etDOBEn.getText().toString().equals("") || etPhoneEn.getText().toString().equals("") || etNameEn.getText().toString().equals("")  ){
                    tvPIEn.setText("");
                }
                else {
                    tvPIEn.setText(CopyOfPassword);
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
                tvTimerEn.setText("Time remaining to delete : "+Counter);
                Counter++;


            }

            public void onFinish(){
                Counter=0;
                String copy = "No Password !!";
                clipString = ClipData.newPlainText("",copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(),"Done, Password deleted ", Toast.LENGTH_SHORT).show();
                tvTimerEn.setText("");
                StartOrStopCopy =1;

            }

        }.start();


    }

    String CopyPassword;

    public void copybtn(){
        if(CheckEmpty>=1) {
            if (StartOrStopCopy == 0) {
                Toast.makeText(getApplicationContext(), " Wait until 60 sec. finish ", Toast.LENGTH_SHORT).show();
            }
            else {
                Counter = 0;// When the user click copy again the timer will count again from zero
                tvTimerEn.setText("Time remaining to delete : ");
                TimerToDeleteCopy();
                String copy = CopyPassword;
                clipString = ClipData.newPlainText("", copy);
                ClipToCopy.setPrimaryClip(clipString);
                Toast.makeText(getApplicationContext(), "Copied , after 60 sec. the password will delete ", Toast.LENGTH_SHORT).show();
                StartOrStopCopy = 0;
            }
        }

        else{
            Toast.makeText(getApplicationContext()," You should get password to copy it ", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.okbtnPIen:
                StrngPassword();
                break;

            case R.id.copybtnPIen:
                copybtn();
                break;


            default:
                break;
        }

    }
}
