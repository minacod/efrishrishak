package com.example.shafy.wannatofly;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public long counter(long num){


        SharedPreferences cosave = getSharedPreferences("com.example.shafy.wannatofly", Context.MODE_PRIVATE);
        if(num!=0){
            cosave.edit().putLong("sec",num).commit();
            return 0;
        }
        else {
            return cosave.getLong("sec",60);
        }



    }


    public int clueNum(int num){

        SharedPreferences cosave = getSharedPreferences("com.example.shafy.wannatofly", Context.MODE_PRIVATE);

        if(num!=0){
            cosave.edit().putInt("clue",num).commit();
            return 0;
        }
        else {
            return cosave.getInt("clue",0);
        }

    }

    public int score(int num){

        SharedPreferences cosave = getSharedPreferences("com.example.shafy.wannatofly", Context.MODE_PRIVATE);
        if(num!=0){
            cosave.edit().putInt("score",num).commit();
            return 0;
        }
        else {
            return cosave.getInt("score",0);
        }

    }
}

