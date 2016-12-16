package com.example.shafy.wannatofly;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class bonus extends AppCompatActivity {

    public ImageView imageView , imageView2 ,imageView3 ,imageView4,imageView5,imageView6;
    public String codes[]={
            "1X54822e5N7QvUt",
            "51HI8u0N56L761V",
            "B65DO299k68T83Y",
            "l9q56Hqlw70bb7S",
            "x807G9g81fTGMQX",
            "8YK77Ge0WCc6mOr",
            "E7o832vbNG7Va8z",
            "f81R608dy3uJ5KG",
            "9Sin1B7933O071D",
            "Mdpi731L3zYIukl",
            "aO1G67D5StvoJqx",
            "7syVNX83WZN270Y",
            "U1L9Mo7uj534LtM",
            "xCPty276Term14P",
            "0492H628PTWYEzc",
            "74gibJF24c908hv",
            "cwLlybNqVZbi5qE",
            "AC49eaWJkRr213B",
            "ZuOT4HdbtkmFovJ",
            "Msvuu5bHugoGN8j",
            "aG8W70exSQo97MZ",
            "OMR65BjjsOU782i",
            "A4GlBM6Vpp4gHjF",
            "SVhi4zhRuXYekZX",
            "0zi47693x8h4nhI",
            "55L22drRhAX8N1W",
            "COR6649699ZC2Dq",
            "9W0t6N1k874x7GO",
            "74hADL5iL42Q67G",
            "0Y9b8zOWC26bo1Z",
            "y03X3Z1I8W4D09K",
            "ml309r9C9o834bE",
            "pmE6V0eFl70mhNo",
            "7r2oR34z6TxIU5U",
            "18S0r60t73deuSt",
            "JoNWz8iZhKPLQUb",
            "JqY7XXiLRtpfphA",
            "8L007424Gr8iC8m",
            "ul7635kmjHHKIVR",
            "wP668GihkWyT2Vr",
            "G4tP90hIF4owSuC",
            "g22rMb90v5x4F0c",
            "e6F97070plm1jDi",
            "76l5SvFXOP5p1Pd",
            "bk0g6B44DnRQ76Q",
            "TFQj84cOCXjrxUN",
            "v322x4mF8ql360u",
            "MkQ7lnHtCju2eYj",
            "9hfRe1psTjjA4QG",
            "wa2bttbz29oUXKg",
            "rz2Ofm6pq368RHS",
            "CEeKJy5958UU54v",
            "TSuZ8WYLXP9fk6u",
            "Of0157a03WA2akb",
            "37lF7434IDA9EOg",
            "oaBkqhdo4ZgjnNQ",
            "WqGfUIKocB2yIkb",
            "5t793K5H9696PzS",
            "46PVd468Rj0G34d",
            "Yimszxm0ONpzKxG",
            "55X0l1NeywtaowN",
            "dDTSPcruqokaz2b",
            "Yc703c7NXgD0wkC",
            "8moq5b5WsBodRyP",
            "H0m62yp78T56iTh",
            "nLGaJjVv0idwTLJ",
            "dhyWBbB6Sn2nDOj",
            "4pwnV36MA86p9ro",
            "xS62O497Uj441jc",
            "J8V2p821NIN9P1i",
            "L228mI9g509x25Q",
            "JBXNs5xnzGTzMeK",
            "8C93vNh52hk5m9Q",
            "22aGO24u4pD9yhA",
            "KYgOy8THlwDsexW",
            "9O1QUq6VOhtBPga",
            "DI0F252YG466GdD",
            "0gn71117j6s8JND",
            "00KI54ZI6i7Q52C",
            "SZ4knvCf5CtpjdH",
            "K9Ht55x4b3AI62r",
            "8Iqexmw39KOI1eH",
            "m27p9L04aL34C2I",
            "35QC8342P526Oej",
            "PH6K30c4ep6tp0g",
            "g78F1631q37O9nE",
            "099Z9u5D5zGRXuD",
            "D14bnV0cM4aS97D",
            "Dvh0h6S757j901J",
            "dHZAb2c925O1qSI",
            "4445ZJ305fvQfEk",
            "CmR0MKa6QE5ueRo",
            "273mq769bmu50vQ",
            "Cq68ep7Lc2AVM5G",
            "iW6eT3Psfhu39Jk",
            "ceUZ5pAX0CEsLxc",
            "d3X2VuHnpx3tlMx",
            "29uGfDYWU7I0d2l",
            "NuwOBVuFns0UT4H",
            "fZn7i5nxe91264K",
            "YP3i53ei88f1C1X",
            "5AK31Z3419O5OhF",
            "wKy1escKuvXctdI",
            "E82HInfbJ0MBp7F",
            "0uWiB7G3v6MSkuu",
            "xOoAt23x38f05Sv",
            "5mnf83O76K6Kb6K",
            "sWkYze62X795hvB",
            "LM9FSFrO2c8utEn",
            "8S3JS1z69MLa9dC",
            "2X8Brsm3vRxlmRB",
            "ZnG65684pA9h92a",
            "17Gq15Q5c9fN18Y",
            "F4zIz6Zy35p9b9f",
            "rjOTP62znuB9jjL",
            "mX4BcU25i2Hq44u",
            "d7wzEOU491OQC2N",
            "8GkN8v059vgamxU",
            "SAtx1lK0Remw5mH",
            "iW6eT3Psfhu39Js",
            "ceUZ5pAX0CEsLxs",
            "d3X2VuHnpx3tlMs",
            "29uGfDYWU7I0d2s",
            "NuwOBVuFns0UT4s",
            "fZn7i5nxe91264s",
            "YP3i53ei88f1C1s",
            "5AK31Z3419O5Ohs",
            "wKy1escKuvXctds",
            "E82HInfbJ0MBp7s",
            "0uWiB7G3v6MSkus",
            "xOoAt23x38f05Ss",
            "5mnf83O76K6Kb6s",
            "sWkYze62X795hvs",
            "LM9FSFrO2c8utEs",
            "8S3JS1z69MLa9ds",
            "2X8Brsm3vRxlmRs",
            "ZnG65684pA9h92s",
            "17Gq15Q5c9fN18s",
            "F4zIz6Zy35p9b9s",
            "rjOTP62znuB9jjs",
            "mX4BcU25i2Hq44s",
            "d7wzEOU491OQC2s",
            "8GkN8v059vgamxs",
            "SAtx1lK0Remw5ms"};

    public int sco;
    public boolean c;
    public  TextView scoreint;




    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.

        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bonus);
        scoreint=(TextView)findViewById(R.id.scoreint);
        sco=((MyApplication)this.getApplication()).score(0);
        String str = Integer.toString(sco);
        scoreint.setText(str);


        mControlsView = findViewById(R.id.fullscreen_content_controls);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        imageView = (ImageView) findViewById(R.id.moving);
        movingc(imageView,width*6/7, 3500,0);

        imageView2 = (ImageView) findViewById(R.id.moving2);
        movingc(imageView2,width*3/5, 4000,0);

        imageView3 = (ImageView) findViewById(R.id.moving3);
        movingc(imageView3,width*6/7, 4000,0);

        imageView4 =(ImageView) findViewById(R.id.bl);
        movingc(imageView4,0,2000,-50);


        imageView5 =(ImageView) findViewById(R.id.br);
        movingc(imageView5,0,2000,50);

        imageView6 =(ImageView) findViewById(R.id.tr);
        movingc(imageView6,0,1500,-50);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;

            imageView = (ImageView) findViewById(R.id.moving);
            imageView2 = (ImageView) findViewById(R.id.moving2);
            imageView3 = (ImageView) findViewById(R.id.moving3);
            movingc(imageView,width*6/7, 3500,0);
            movingc(imageView2,width*3/5, 4000,0);
            movingc(imageView3,width*6/7, 4000,0);

            imageView4 =(ImageView) findViewById(R.id.bl);
            movingc(imageView4,0,2000,-100);


            imageView5 =(ImageView) findViewById(R.id.br);
            movingc(imageView5,0,2000,-100);

            imageView6 =(ImageView) findViewById(R.id.tr);
            movingc(imageView6,0,1500,-100);

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;

            imageView = (ImageView) findViewById(R.id.moving);
            //movingc(imageView,-width*6/7, 0,0);

            imageView2 = (ImageView) findViewById(R.id.moving2);
            //movingc(imageView2,-width*3/5, 0,0);

            imageView3 = (ImageView) findViewById(R.id.moving3);
            //movingc(imageView3,-width*6/7, 0,0);

            movingc(imageView,width*6/7, 3500,0);
            movingc(imageView2,width*3/5, 4000,0);
            movingc(imageView3,width*6/7, 4000,0);

            imageView4 =(ImageView) findViewById(R.id.bl);
            movingc(imageView4,0,2000,-100);


            imageView5 =(ImageView) findViewById(R.id.br);
            movingc(imageView5,0,2000,-100);

            imageView6 =(ImageView) findViewById(R.id.tr);
            movingc(imageView6,0,2000,-100);

        }
    }


    private void movingc (final ImageView iv , int width , final int time, final int hight ){
        iv.animate()

                .translationX(width)
                .translationY(hight)
                .setDuration(time)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }


                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (hight != 0) {
                            iv.animate()
                                    .translationY(-hight / 4)
                                    .setDuration(time)
                                    .setListener(new Animator.AnimatorListener() {
                                        @Override
                                        public void onAnimationStart(Animator animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            // remove image view from framlayout
                                        }

                                        @Override
                                        public void onAnimationCancel(Animator animation) {
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animator animation) {
                                        }
                                    }).start();

                        }
                        else {
                            iv.animate()
                                    .setListener(new Animator.AnimatorListener() {
                                        @Override
                                        public void onAnimationStart(Animator animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            // remove image view from framlayout
                                        }

                                        @Override
                                        public void onAnimationCancel(Animator animation) {
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animator animation) {
                                        }
                                    }).start();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);


        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }


    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public void qrcode(View v) {

        if (v.getId() == R.id.scan) {
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();

        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {

            String scanContent = scanningResult.getContents();
            SharedPreferences save = getSharedPreferences("com.example.shafy.bati5aa", Context.MODE_PRIVATE);
            int size = save.getInt("array_size", 0);
            if(size!=0) {

                codes = new String[size];
                for (int i = 0; i < size; i++)
                    codes[i]=save.getString("array_" + i, null);
            }
            for (int i=0;i<codes.length;i++){

                if(scanContent!=null){
                if (scanContent.equals(codes[i])){

                    MediaPlayer m = MediaPlayer.create(this,R.raw.yay);
                    m.start();
                    sco=sco+10;
                    ((MyApplication)this.getApplication()).score(sco);
                    codes[i]=null;
                    SharedPreferences.Editor edit = save.edit();
                    edit.putInt("array_size", codes.length);
                    for(int j=0;j<codes.length; j++)
                        edit.putString("array_" + j, codes[j]);
                    edit.commit();
                    c = true;
                    Intent ii = new Intent(this,bonus.class);
                    startActivity(ii);
                    break;
                }
                else if(!(scanContent.equals(codes[i]))) {

                    c = false;

                }
                }
                else{
                    c=true;
                }
            }

            if (!c){

                MediaPlayer mn = MediaPlayer.create(this,R.raw.no);
                mn.start();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "ممنوع الغش", Toast.LENGTH_SHORT);
                toast.show();
                sco=sco-1;
                ((MyApplication)this.getApplication()).score(sco);
                Intent ii = new Intent(this,bonus.class);
                startActivity(ii);

            }

        }
        else{

            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent ii = new Intent(this,home.class);
        startActivity(ii);
    }

}
