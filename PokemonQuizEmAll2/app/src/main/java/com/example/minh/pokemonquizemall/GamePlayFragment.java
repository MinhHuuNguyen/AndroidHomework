package com.example.minh.pokemonquizemall;


import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamePlayFragment extends Fragment {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.iv_question)
    ImageView ivQuestion;

    @BindView(R.id.tv_answer1)
    TextView tvAnswer1;
    @BindView(R.id.tv_answer2)
    TextView tvAnswer2;
    @BindView(R.id.tv_answer3)
    TextView tvAnswer3;
    @BindView(R.id.tv_answer4)
    TextView tvAnswer4;

    @BindView(R.id.tv_tag)
    TextView tvTag;

    @BindView(R.id.fl_gameplay)
    FrameLayout flGamePlay;
    @BindView(R.id.ll_gameplay)
    LinearLayout llGamePlay;
    @BindView(R.id.ll_group12)
    LinearLayout llGroup12;
    @BindView(R.id.ll_group34)
    LinearLayout llGroup34;

    @BindView(R.id.rl_answer1)
    RelativeLayout rlAnswer1;
    @BindView(R.id.rl_answer2)
    RelativeLayout rlAnswer2;
    @BindView(R.id.rl_answer3)
    RelativeLayout rlAnswer3;
    @BindView(R.id.rl_answer4)
    RelativeLayout rlAnswer4;
    @BindView(R.id.rl_question)
    RelativeLayout rlQuestion;

    @BindView(R.id.tv_score)
    TextView tvScore;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private String namePokemon1;
    private String namePokemon2;
    private String namePokemon3;

    private int count = 0;

    private CountDownTimer countDownTimer;

    private View viewAnswerTrue;
    public MediaPlayer mediaPlayerMusic;
    public MediaPlayer mediaPlayerSound;

    public GamePlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_play, container, false);
        ButterKnife.bind(this, rootView);
//        if (((MainActivity)getActivity()).isPlayedMusic) {
//            ((MainActivity) getActivity()).homeMediaPlayer.stop();
//            ((MainActivity) getActivity()).homeMediaPlayer.release();
//            ((MainActivity) getActivity()).playMediaPLayer.start();
//            ((MainActivity) getActivity()).playMediaPLayer.release();
//        }
//        ObjectAnimator animator = ObjectAnimator.
        Pokemon pokemon = DbHelper.getInstance().selectRandomPokemon();
        setupProgressBar(pokemon);
        Random random = new Random();
        int position = random.nextInt(4) + 1;
        Log.d(TAG, pokemon.getName());
        viewAnswerTrue = setupUIFromPokemon(pokemon, position);
        tvScore.setText(String.format("%s",((MainActivity)getActivity()).getScore()));
        setNamePokemon1(pokemon);
        setNamePokemon2(pokemon);
        setNamePokemon3(pokemon);
        setTextAnswer(position);
        addListener(pokemon);
        addMusic();
        return rootView;
    }

    private void setupProgressBar(Pokemon pokemon) {
        progressBar.setRotation(180);
        progressBar.setProgress(count);
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_progressbar));
        countDownTimer = new CountDownTimer(20000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                count++;
                progressBar.setProgress(count);
            }

            @Override
            public void onFinish() {
                changeFragment(new HomeFragment());
                count++;
                progressBar.setProgress(count);
            }
        };
        countDownTimer.start();
    }

    private void addMusic() {
        mediaPlayerMusic = MediaPlayer.create(getContext(),R.raw.playmusic);
        mediaPlayerMusic.start();
    }

    private void addListener(final Pokemon pokemon) {
        rlAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer1 == viewAnswerTrue){
                    rlAnswer1.setBackgroundResource(R.drawable.clicked_true);
                    ((MainActivity)getActivity()).setScore(((MainActivity)getActivity()).getScore() + 1);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.trueanswer);
                }else {
                    rlAnswer1.setBackgroundResource(R.drawable.clicked_false);
                    viewAnswerTrue.setBackgroundResource(R.drawable.clicked_true);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.falseanswer);
                }
                animationOut();
                mediaPlayerSound.start();
                tvTag.setText(String.format("%s %s", pokemon.getTag(), pokemon.getName()));
                disableClick(rlAnswer2, rlAnswer3, rlAnswer4);

                moveToNextQuestion(new GamePlayFragment());
            }
        });
        rlAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer2 == viewAnswerTrue){
                    rlAnswer2.setBackgroundResource(R.drawable.clicked_true);
                    ((MainActivity)getActivity()).setScore(((MainActivity)getActivity()).getScore() + 1);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.trueanswer);
                }else {
                    rlAnswer2.setBackgroundResource(R.drawable.clicked_false);
                    viewAnswerTrue.setBackgroundResource(R.drawable.clicked_true);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.falseanswer);
                }
                mediaPlayerSound.start();
                tvTag.setText(String.format("%s %s", pokemon.getTag(), pokemon.getName()));
                disableClick(rlAnswer1, rlAnswer3, rlAnswer4);
                moveToNextQuestion(new GamePlayFragment());
            }
        });
        rlAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer3 == viewAnswerTrue){
                    rlAnswer3.setBackgroundResource(R.drawable.clicked_true);
                    ((MainActivity)getActivity()).setScore(((MainActivity)getActivity()).getScore() + 1);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.trueanswer);
                }else {
                    rlAnswer3.setBackgroundResource(R.drawable.clicked_false);
                    viewAnswerTrue.setBackgroundResource(R.drawable.clicked_true);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.falseanswer);
                }
                mediaPlayerSound.start();
                tvTag.setText(String.format("%s %s", pokemon.getTag(), pokemon.getName()));
                disableClick(rlAnswer1, rlAnswer2, rlAnswer4);
                moveToNextQuestion(new GamePlayFragment());
            }
        });
        rlAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer4 == viewAnswerTrue){
                    rlAnswer4.setBackgroundResource(R.drawable.clicked_true);
                    ((MainActivity)getActivity()).setScore(((MainActivity)getActivity()).getScore() + 1);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.trueanswer);
                }else {
                    rlAnswer4.setBackgroundResource(R.drawable.clicked_false);
                    viewAnswerTrue.setBackgroundResource(R.drawable.clicked_true);
                    mediaPlayerSound = MediaPlayer.create(getContext(), R.raw.falseanswer);
                }
                mediaPlayerSound.start();
                tvTag.setText(String.format("%s %s", pokemon.getTag(), pokemon.getName()));
                disableClick(rlAnswer1, rlAnswer2, rlAnswer3);
                moveToNextQuestion(new GamePlayFragment());
            }
        });
    }

    private View setupUIFromPokemon(Pokemon pokemon, int position){
        try {
            InputStream ims = getActivity().getAssets().open(pokemon.getImg());
            Drawable d = Drawable.createFromStream(ims, null);
//            BitmapDrawable bitmap = (BitmapDrawable) BitmapDrawable.createFromStream(ims, null);
            ivQuestion.setImageDrawable(d);
//            ivQuestion.setImageBitmap(createShadowBitmap(bitmap));
            animationIn();
        } catch (IOException e) {
            e.printStackTrace();
        }

        flGamePlay.setBackgroundColor(Color.parseColor(pokemon.getColor()));
        switch (position) {
            case 1:
                tvAnswer1.setText(pokemon.getName());
                return rlAnswer1;
            case 2:
                tvAnswer2.setText(pokemon.getName());
                return rlAnswer2;
            case 3:
                tvAnswer3.setText(pokemon.getName());
                return rlAnswer3;
            case 4:
                tvAnswer4.setText(pokemon.getName());
                return rlAnswer4;
            default:
        }
        return null;
    }

    private void disableClick(RelativeLayout relativeLayout1, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3){
        relativeLayout1.setClickable(false);
        relativeLayout2.setClickable(false);
        relativeLayout3.setClickable(false);
    }

    private void moveToNextQuestion(final Fragment fragment){
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            }
        }, 3000);
    }

    private String setNamePokemon1(Pokemon pokemon){
        do {
            namePokemon1 = DbHelper.getInstance().selectRandomName();
        }while (namePokemon1 == pokemon.getName());
        return namePokemon1;
    }

    private String setNamePokemon2 (Pokemon pokemon){
        do {
            namePokemon2 = DbHelper.getInstance().selectRandomName();
        }while (namePokemon2 == pokemon.getName() && namePokemon2 == namePokemon1);
        return namePokemon2;
    }

    private String setNamePokemon3 (Pokemon pokemon){
        do {
            namePokemon3 = DbHelper.getInstance().selectRandomName();
        }while (namePokemon3 == pokemon.getName() && namePokemon3 == namePokemon1 && namePokemon3 == namePokemon2);
        return namePokemon3;
    }

    private void setTextAnswer(int position){
        switch (position){
            case 1:
                tvAnswer2.setText(namePokemon1);
                tvAnswer3.setText(namePokemon2);
                tvAnswer4.setText(namePokemon3);
                break;
            case 2:
                tvAnswer1.setText(namePokemon1);
                tvAnswer3.setText(namePokemon2);
                tvAnswer4.setText(namePokemon3);
                break;
            case 3:
                tvAnswer2.setText(namePokemon1);
                tvAnswer1.setText(namePokemon2);
                tvAnswer4.setText(namePokemon3);
                break;
            case 4:
                tvAnswer2.setText(namePokemon1);
                tvAnswer3.setText(namePokemon2);
                tvAnswer1.setText(namePokemon3);
                break;
            default:
        }
    }

    private void animationOut(){
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(getContext(),R.animator.animator_flip);
        animator.setTarget(ivQuestion);
        animator.setDuration(300);
        animator.start();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_translate_in);
                rlQuestion.startAnimation(animation);
            }
        }, 1000);
    }

    private void animationIn(){
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_translate_out);
        rlQuestion.startAnimation(animation);
    }

    private Bitmap createShadowBitmap(Bitmap bitmap){
        Bitmap bm = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        for (int i =0; i < bitmap.getWidth(); i++){
            for (int j =0; j < bitmap.getHeight(); j++){
                int p = bitmap.getPixel(i, j);
                int alpha = Color.alpha(p);
                if (alpha != 0){
                    bm.setPixel(i, j, Color.BLACK);
                }
            }
        }
        return bm;
    }

    private void changeFragment(Fragment fragment) {
        this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
    }
}
