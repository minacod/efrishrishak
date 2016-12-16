package com.example.shafy.wannatofly;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class elsh3ar extends AppCompatActivity {

    private ImageView imageView , imageView2 ,imageView3 ,imageView4,imageView5,imageView6;
    private boolean status=false;
    private MediaPlayer sh3ar;

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

        setContentView(R.layout.activity_elsh3ar);

        sh3ar = MediaPlayer.create(this,R.raw.she3aar);

        mVisible = true;
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


        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    public  void play(View view){

        if (!status){

            sh3ar.start();
            sh3ar.setLooping(true);
            status=true;

        }



    }
    public  void pause(View view){

        sh3ar.pause();
        status=false;
    }
    public  void stop(View view){

        sh3ar.stop();
        status=false;
        sh3ar = MediaPlayer.create(this,R.raw.she3aar);
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
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }


    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar

        mVisible = true;

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
