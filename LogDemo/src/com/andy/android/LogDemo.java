package com.andy.android;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LogDemo extends Activity {
 private static final String ACTIVITY_TAG="LogDemo";
 private Button myButtton;

    static final String LIFT_TAG = "LogDemo";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.v(LogDemo.LIFT_TAG,"FirstAcvity --->onCreate");
        //ͨ��findViewById�ҵ�Button��Դ
        Button myButton = (Button)findViewById(R.id.myButton);
        //�����¼���Ӧ
        myButton.setOnClickListener(new ButtonOnClickListener());

    }
    class ButtonOnClickListener implements OnClickListener{
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(LogDemo.this,Activity2.class);
            LogDemo.this.startActivity(intent);
//                Log.v(LogDemo.ACTIVITY_TAG, "This is Verbose.");
//                Log.d(LogDemo.ACTIVITY_TAG, "This is Debug.");
//                Log.i(LogDemo.ACTIVITY_TAG, "This is Information");
//                Log.w(LogDemo.ACTIVITY_TAG, "This is Warnning.");
//                Log.e(LogDemo.ACTIVITY_TAG, "This is Error.");
        }
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG,"FirstAcvity --->onDestory");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "FirstAcvity --->onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "FirstAcvity --->onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "FirstAcvity --->onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "FirstAcvity --->onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Log.v(LogDemo.LIFT_TAG, "FirstAcvity --->onStop");
        super.onStop();
    }

}

