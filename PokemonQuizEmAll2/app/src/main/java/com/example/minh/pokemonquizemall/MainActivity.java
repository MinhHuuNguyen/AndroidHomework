package com.example.minh.pokemonquizemall;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ImageView ivPlay;
    private ImageView ivSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReference();
        setupUIBtnPlay();
        addListener();
    }

    private void getReference() {
        ivPlay = (ImageView) findViewById(R.id.iv_play);
        ivSetting = (ImageView) findViewById(R.id.iv_setting);
    }

    private void setupUIBtnPlay(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float width = metrics.widthPixels;
        float height = metrics.heightPixels;
        float size = width * 0.4f;
        ivPlay.setLayoutParams(new RelativeLayout.LayoutParams((int)size,(int)size));
        ivPlay.setX(width / 2 - ivPlay.getLayoutParams().width / 2);
        ivPlay.setY(height * 5 / 8 - ivPlay.getLayoutParams().height / 2);
    }

    private  void addListener(){
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked play");
                changeFragment(new GamePlayFragment());
            }
        });

        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new SettingFragment());
                Log.d(TAG, "Clicked setting");
            }
        });
    }
    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).addToBackStack(null).commit();
    }
}
