package com.example.minh.pokemonquizemall;


import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.iv_play)
    ImageView ivPlay;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.tv_current_score)
    TextView tvCurrentScore;
    @BindView(R.id.tv_high_score)
    TextView tvHighScore;

    public MediaPlayer mediaPlayerSound;
    public MediaPlayer mediaPlayer;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.uiclick);
        Log.d(TAG, String.format("aaaaaaaaaaaaaaaaaaaaaa %s",((MainActivity)getActivity()).isPlayedMusic));
        if (((MainActivity) getActivity()).isPlayedMusic == true) {
            ((MainActivity) getActivity()).homeMediaPlayer.start();
//            ((MainActivity) getActivity()).homeMediaPlayer.release();
        }else ;
        setupUIBtnPlay();
        addListener();
        setFontTextview("fonts/PoplarStd.ttf", tvHighScore);
        setFontTextview("fonts/StencilStd.ttf", tvCurrentScore);
        tvCurrentScore.setText(String.format("%s",((MainActivity)getActivity()).getScore()));
        tvHighScore.setText(String.format("HIGH SCORE: %s",((MainActivity)getActivity()).getHighScore()));
        return rootView;
    }

    private void setFontTextview(String font, TextView textView){
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),font);
        textView.setTypeface(typeface);
    }

    private void setupUIBtnPlay(){
        DisplayMetrics metrics = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
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
                changeFragment(new GamePlayFragment());
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound);
            }
        });

        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new SettingFragment());
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound);
            }
        });
    }

    private void checkSound(boolean isPlayedSound, MediaPlayer mediaPlayer){
        if (isPlayedSound) {
            mediaPlayer.start();
        }else;
    }

    private void changeFragment(Fragment fragment) {
        this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).addToBackStack(null).commit();
    }

}
