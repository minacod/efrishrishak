package com.example.shafy.wannatofly;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class home extends AppCompatActivity {


    public int sco;
    public  TextView scoreint;
    private MediaPlayer starting;
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
    private static final int AUTO_HIDE_DELAY_MILLIS = 300;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        starting = MediaPlayer.create(this,R.raw.home);
        starting.start();

        scoreint=(TextView)findViewById(R.id.scoreint);
        sco=((MyApplication)this.getApplication()).score(0);
        String str = Integer.toString(sco);
        scoreint.setText(str);

        mVisible = true;



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

        handleNotification();
    }

    private void handleNotification() {
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5000, pendingIntent);
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

    public void onClick(View view){

        starting.stop();
        Intent i = new Intent(this,elsh3ar.class);
        startActivity(i);

    }

    public void puzzle(View view){

        starting.stop();
        Intent i = new Intent(this,lo8z.class);
        startActivity(i);

    }
    public void bonus(View view){

        starting.stop();
        Intent i = new Intent(this,bonus.class);
        startActivity(i);
    }
    public void map(View view){

        starting.stop();
        Intent i = new Intent(this,map.class);
        startActivity(i);

    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
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
        // Show the system bar


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
