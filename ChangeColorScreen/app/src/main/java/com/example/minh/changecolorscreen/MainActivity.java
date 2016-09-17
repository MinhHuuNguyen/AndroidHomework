package com.example.minh.changecolorscreen;

import android.graphics.Color;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgbutton;
    private Camera camera;
    Camera.Parameters parameters;
    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getCamera();
        setContentView(R.layout.activity_main);
        getReference();
        addListeners();
    }

//    private void getCamera(){
//        try {
//            camera = Camera.open();
//        }
//        catch (RuntimeException e) {
//            Log.e(TAG, String.format("Could not open camera: %s", e.getMessage()));
//        }
//    }
    void getReference(){
        tgbutton = (ToggleButton)findViewById(R.id.tg_button);
        background = (RelativeLayout) findViewById(R.id.background);
    }
    private void addListeners(){
        tgbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("tgbutton check changed: %s", isChecked));
                if (isChecked) {
                    //Camera.Parameters params = camera.getParameters();
                   // params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    //camera.setParameters(params);
                    background.setBackgroundColor(Color.RED);
                } else {
                   // Camera.Parameters params = camera.getParameters();
                   // params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                   // camera.setParameters(params);
                    background.setBackgroundColor(Color.BLUE);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        //Camera.Parameters params = camera.getParameters();
        //params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        //camera.setParameters(params);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Camera.Parameters params = camera.getParameters();
        //params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        //camera.setParameters(params);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        //camera.release();
        super.onDestroy();
    }
}

