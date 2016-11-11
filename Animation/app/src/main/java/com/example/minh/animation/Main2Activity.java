package com.example.minh.animation;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button btnChange;
    private boolean aboolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.getSupportActionBar().hide();
        btnChange = (Button) findViewById(R.id.btn_changefragment);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aboolean) {
                    changeFragment(new AccentFragment());
                    aboolean = false;
                }else{
                    changeFragment(new PrimaryFragment());
                    aboolean = true;
                }
            }
        });


    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).replace(R.id.fl_container, fragment).commit();
    }
}
