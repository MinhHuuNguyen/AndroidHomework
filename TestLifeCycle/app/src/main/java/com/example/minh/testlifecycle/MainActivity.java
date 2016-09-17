package com.example.minh.testlifecycle;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumberOnCreate;
    private TextView tvNumberOnStart;
    private TextView tvNumberOnRestart;
    private TextView tvNumberOnResume;
    private TextView tvNumberOnPause;
    private TextView tvNumberOnStop;
    private TextView tvNumberOnDestroy;

    private Button btnGoToB;

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
        setContentView(R.layout.activity_main);
        getReference();
        tvNumberOnCreate.setText(String.valueOf(onCreateCount));
        Log.d(TAG, "onCreate");
        btnGoToB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        onStartCount++;
        super.onStart();
        tvNumberOnStart.setText(String.valueOf(onStartCount));
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        onRestartCount++;
        super.onRestart();
        tvNumberOnRestart.setText(String.valueOf(onRestartCount));
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        onResumeCount++;
        super.onResume();
        tvNumberOnResume.setText(String.valueOf(onResumeCount));
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        onPauseCount++;
        super.onPause();
        tvNumberOnPause.setText(String.valueOf(onPauseCount));
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        onStopCount++;
        super.onStop();
        tvNumberOnStop.setText(String.valueOf(onStopCount));
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
        tvNumberOnDestroy.setText(String.valueOf(onDestroyCount));
        Log.d(TAG, "onDestroy");
    }

    private void getReference(){
        tvNumberOnCreate = (TextView) findViewById(R.id.tv_numberoncreate);
        tvNumberOnStart = (TextView) findViewById(R.id.tv_numberonstart);
        tvNumberOnRestart = (TextView) findViewById(R.id.tv_numberonrestart);
        tvNumberOnResume = (TextView) findViewById(R.id.tv_numberonresume);
        tvNumberOnPause = (TextView) findViewById(R.id.tv_numberonpause);
        tvNumberOnStop = (TextView) findViewById(R.id.tv_numberonstop);
        tvNumberOnDestroy = (TextView) findViewById(R.id.tv_numberondestroy);
        btnGoToB = (Button) findViewById(R.id.btn_gotob);
    }
}
