package com.example.shafy.wannatofly;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class clues extends AppCompatActivity implements SensorEventListener {

    private int cluenum;
    private TextView tv1 ,tv2 ,tv3,tv4;
    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    public ImageView imageView , imageView2 ,imageView3 ,imageView4,imageView5,imageView6;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

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


    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
        }
    };
    private boolean mVisible;
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
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clues);


        mVisible = true;
        tv1=(TextView)findViewById(R.id.cluesText1);
        tv2=(TextView)findViewById(R.id.cluesText2);
        tv3=(TextView)findViewById(R.id.cluesText3);
        tv4=(TextView)findViewById(R.id.sec);
        cluenum =((MyApplication)this.getApplication()).clueNum(0);
        if(cluenum==1)
        {
            tv1.setText("4 حروف");
            tv2.setText("فى فالابلكشن");
            tv3.setText("كابيتال");

        }
        else if (cluenum==2)
        {
            tv1.setText("القبطى");
            tv2.setText("عدد الحروف");
            tv3.setText("حولين الملعب");
        }
        else if (cluenum==3)
        {
            tv1.setText("digital");
            tv2.setText("studio");
            tv3.setText("كمل");
            tv4.setText("9");
        }
        else if (cluenum==4)
        {
            tv1.setText("فى كام");
            tv2.setText("حامل الايقونات");
            tv3.setText("سمكة");
            tv4.setText("3");
        }
        else if (cluenum==5)
        {
            tv3.setText("دور تحت اسم");
            tv2.setText("المستشفى ");
            tv1.setText("على ورقة فيها حروف الباسورد");
        }
        else if (cluenum==6)
        {
            tv1.setText("القاعة");
            tv2.setText("اللى في");
            tv3.setText("عدد اللمد النيون");
        }
        else if (cluenum==7)
        {
            tv1.setText("مبروك اسأل");
            tv2.setText("ابونا");
            tv3.setText("على الكنز");
            tv4.setText("l");
        }
        else if (cluenum==8)
        {
            tv1.setText("فوق اكبر");
            tv2.setText("بوص");
            tv3.setText("كرمة مريوط");
            tv4.setText("t");
        }
        else if (cluenum==9)
        {
            tv1.setText(" الزهور");
            tv2.setText("عدد");
            tv3.setText("اللى مرتبطة بمصر القديمة");
            tv4.setText("f");
        }
        else if (cluenum==10)
        {
            tv1.setText("كل واحد يدور");
            tv2.setText("فى الجواب بتعوا");
            tv3.setText("جمعوا الباسودر ورتبه ابجدى");
            tv4.setText("p");
        }
        else if (cluenum==11)
        {
            tv1.setText("مبروك اسأل");
            tv2.setText("كيرلس كمال");
            tv3.setText("عن الكنز");
            tv4.setText("8");
        }
        else if (cluenum==12)
        {
            tv1.setText("الباسورد");
            tv2.setText("30.014269, 31.220180");
            tv3.setText("اسمه هنا");
            tv4.setText("s");
        }



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

        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            float xAxis = sensorEvent.values[0];
            float yAxis = sensorEvent.values[1];
            float zAxis = sensorEvent.values[2];

            showClues(xAxis,yAxis,zAxis);
        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
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


    public void showClues(float x,float y ,float z){

        if(cluenum==1){
        if (x<9&&x>7){
            tv1.setVisibility(View.VISIBLE);
            if(y<5&&y>3){
                tv2.setVisibility(View.VISIBLE);
                if(z<7&&z>5)tv3.setVisibility(View.VISIBLE);
                else tv3.setVisibility(View.INVISIBLE);
            }
            else tv2.setVisibility(View.INVISIBLE);
        }
        else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==2){
            if (x<8&&x>6){
                tv1.setVisibility(View.VISIBLE);
                if(y<7&&y>5){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<7&&z>5)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==3){
            if (x<8&&x>6){
                tv1.setVisibility(View.VISIBLE);
                if(y<9&&y>7){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<7&&z>5)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==4){
            if (x<8&&x>6){
                tv1.setVisibility(View.VISIBLE);
                if(y<5&&y>3){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<7&&z>5)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==5){
            if (x<4&&x>2){
                tv1.setVisibility(View.VISIBLE);
                if(y<7&&y>5){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<9&&z>7)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==6){
            if (x<2&&x>0){
                tv1.setVisibility(View.VISIBLE);
                if(y<9&&y>7){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<4&&z>2)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==7) {
            if (x < 8 && x > 6) {
                tv1.setVisibility(View.VISIBLE);
                if (y < 2 && y > 0) {
                    tv2.setVisibility(View.VISIBLE);
                    if (z < 4 && z > 2) tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                } else tv2.setVisibility(View.INVISIBLE);
            } else tv1.setVisibility(View.INVISIBLE);
        }
            if(cluenum==8){
                if (x<7&&x>5){
                    tv1.setVisibility(View.VISIBLE);
                    if(y<5&&y>3){
                        tv2.setVisibility(View.VISIBLE);
                        if(z<2&&z>0)tv3.setVisibility(View.VISIBLE);
                        else tv3.setVisibility(View.INVISIBLE);
                    }
                    else tv2.setVisibility(View.INVISIBLE);
                }
                else tv1.setVisibility(View.INVISIBLE);
            }
            if(cluenum==9){
                if (x<8&&x>6){
                    tv1.setVisibility(View.VISIBLE);
                    if(y<8&&y>6){
                        tv2.setVisibility(View.VISIBLE);
                        if(z<9&&z>7)tv3.setVisibility(View.VISIBLE);
                        else tv3.setVisibility(View.INVISIBLE);
                    }
                    else tv2.setVisibility(View.INVISIBLE);
                }
                else tv1.setVisibility(View.INVISIBLE);
            }
        if(cluenum==9){
            if (x<8&&x>6){
                tv1.setVisibility(View.VISIBLE);
                if(y<5&&y>3){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<7&&z>5)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==10){
            if (x<4&&x>2){
                tv1.setVisibility(View.VISIBLE);
                if(y<5&&y>3){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<2&&z>0)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==11){
            if (x<8&&x>6){
                tv1.setVisibility(View.VISIBLE);
                if(y<9&&y>7){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<7&&z>5)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
        }
        if(cluenum==12){
            if (x<9&&x>7){
                tv1.setVisibility(View.VISIBLE);
                if(y<6&&y>4){
                    tv2.setVisibility(View.VISIBLE);
                    if(z<6&&z>4)tv3.setVisibility(View.VISIBLE);
                    else tv3.setVisibility(View.INVISIBLE);
                }
                else tv2.setVisibility(View.INVISIBLE);
            }
            else tv1.setVisibility(View.INVISIBLE);
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

        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

}
