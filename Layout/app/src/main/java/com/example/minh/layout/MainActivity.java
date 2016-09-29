package com.example.minh.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv1_rl1)
    ImageView iv1rl1;

    @BindView(R.id.iv1_rl2)
    ImageView iv1rl2;

    @BindView(R.id.iv2_rl2)
    ImageView iv2rl2;

    @BindView(R.id.iv3_rl2)
    ImageView iv3rl2;

    @BindView(R.id.iv4_rl2)
    ImageView iv4rl2;

    @BindView(R.id.iv5_rl2)
    ImageView iv5rl2;

    @BindView(R.id.iv6_rl2)
    ImageView iv6rl2;

    @BindView(R.id.iv7_rl2)
    ImageView iv7rl2;

    @BindView(R.id.iv8_rl2)
    ImageView iv8rl2;

    @BindView(R.id.iv9_rl2)
    ImageView iv9rl2;

    @BindView(R.id.iv1_rl3)
    ImageView iv1rl3;

    @BindView(R.id.iv2_rl3)
    ImageView iv2rl3;

    @BindView(R.id.iv3_rl3)
    ImageView iv3rl3;

    @BindView(R.id.iv4_rl3)
    ImageView iv4rl3;

    @BindView(R.id.iv5_rl3)
    ImageView iv5rl3;

    @BindView(R.id.iv6_rl3)
    ImageView iv6rl3;

    @BindView(R.id.iv7_rl3)
    ImageView iv7rl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        iv1rl1.setBackgroundResource(R.drawable.oval_avatar);

        iv1rl2.setBackgroundResource(R.drawable.bitmap4);
        iv2rl2.setBackgroundResource(R.drawable.bitmap7);
        iv3rl2.setBackgroundResource(R.drawable.bitmap3);
        iv4rl2.setBackgroundResource(R.drawable.bitmap2);
        iv5rl2.setBackgroundResource(R.drawable.bitmap1);
        iv6rl2.setBackgroundResource(R.drawable.bitmap1);
        iv7rl2.setBackgroundResource(R.drawable.bitmap8);
        iv8rl2.setBackgroundResource(R.drawable.bitmap6);
        iv9rl2.setBackgroundResource(R.drawable.play_icon_group);

        iv1rl3.setBackgroundResource(R.drawable.bitmap12);
        iv2rl3.setBackgroundResource(R.drawable.bitmap11);
        iv3rl3.setBackgroundResource(R.drawable.bitmap3);
        iv4rl3.setBackgroundResource(R.drawable.bitmap2);
        iv5rl3.setBackgroundResource(R.drawable.bitmap1);
        iv6rl3.setBackgroundResource(R.drawable.bitmap1);
        iv7rl3.setBackgroundResource(R.drawable.bitmap8);
    }
}
