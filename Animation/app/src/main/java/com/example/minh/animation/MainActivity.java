package com.example.minh.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    View vItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();
        vItem = findViewById(R.id.v_item);
        vItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationByXml();
                Log.d(TAG, "Clicked");
            }
        });
    }

    private void animationByXml(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.multiple_animation);
        vItem.startAnimation(animation);
    }
}
