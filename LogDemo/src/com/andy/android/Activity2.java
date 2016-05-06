package com.andy.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by za407 on 2016/5/6.
 */
public class Activity2 extends Activity{
    private static final String LIFT_TAG="LogActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setContentView(R.layout.second);
        Log.v(LogDemo.LIFT_TAG,"SecondActivity--->onCreate");
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG,"SecondActivity --->onDestory");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "SecondActivity --->onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "SecondActivity --->onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "SecondActivity --->onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "SecondActivity --->onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "SecondActivity --->onStop");
        super.onStop();
    }
}
