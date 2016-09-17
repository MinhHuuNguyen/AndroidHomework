package com.example.minh.testlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Minh on 9/16/2016.
 */
public class ActivityB extends AppCompatActivity{

    private TextView tvNumberOnCreate1;
    private TextView tvNumberOnStart1;
    private TextView tvNumberOnRestart1;
    private TextView tvNumberOnResume1;
    private TextView tvNumberOnPause1;
    private TextView tvNumberOnStop1;
    private TextView tvNumberOnDestroy1;

    private int onCreateCount = 0;
    private int onStartCount = 0;
    private int onRestartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onStopCount = 0;
    private int onDestroyCount = 0;

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        onCreateCount++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        getReference();
        tvNumberOnCreate1.setText(String.valueOf(onCreateCount));
        Log.d(TAG, "onCreate");
    }
    @Override
    protected void onStart() {
        onStartCount++;
        super.onStart();
        tvNumberOnStart1.setText(String.valueOf(onStartCount));
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        onRestartCount++;
        super.onRestart();
        tvNumberOnRestart1.setText(String.valueOf(onRestartCount));
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        onResumeCount++;
        super.onResume();
        tvNumberOnResume1.setText(String.valueOf(onResumeCount));
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        onPauseCount++;
        super.onPause();
        tvNumberOnPause1.setText(String.valueOf(onPauseCount));
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        onStopCount++;
        super.onStop();
        tvNumberOnStop1.setText(String.valueOf(onStopCount));
        Log.d(TAG, "onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onDestroy() {
        onDestroyCount++;
        super.onDestroy();
        tvNumberOnDestroy1.setText(String.valueOf(onDestroyCount));
        Log.d(TAG, "onDestroy");
    }

    private void getReference(){
        tvNumberOnCreate1 = (TextView) findViewById(R.id.tv_numberoncreate1);
        tvNumberOnStart1 = (TextView) findViewById(R.id.tv_numberonstart1);
        tvNumberOnRestart1 = (TextView) findViewById(R.id.tv_numberonrestart1);
        tvNumberOnResume1 = (TextView) findViewById(R.id.tv_numberonresume1);
        tvNumberOnPause1 = (TextView) findViewById(R.id.tv_numberonpause1);
        tvNumberOnStop1 = (TextView) findViewById(R.id.tv_numberonstop1);
        tvNumberOnDestroy1 = (TextView) findViewById(R.id.tv_numberondestroy1);
    }
}
