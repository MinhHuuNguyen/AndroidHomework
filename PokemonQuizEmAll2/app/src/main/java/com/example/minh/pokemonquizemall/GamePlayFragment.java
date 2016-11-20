package com.example.minh.pokemonquizemall;


import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

    @BindView(R.id.tv_score)
    TextView tvScore;

    private String namePokemon1;
    private String namePokemon2;
    private String namePokemon3;
    private int position;

    private View viewAnswerTrue;
    private View viewAnswer;
    private AssetManager assetManager;
    public GamePlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_play, container, false);
        ButterKnife.bind(this, rootView);

        Pokemon pokemon = DbHelper.getInstance().selectRandomPokemon();
        Random random = new Random();
        position = random.nextInt(4) + 1;
        Log.d(TAG, pokemon.getName());
        viewAnswerTrue = setupUIFromPokemon(pokemon, position);
        tvScore.setText(String.format("%s",((MainActivity)getActivity()).getScore()));
        setNamePokemon1(pokemon);
        setNamePokemon2(pokemon);
        setNamePokemon3(pokemon);
        setTextAnswer(position);
        addListener(pokemon);
        return rootView;
    }

    private void addListener(final Pokemon pokemon) {
        rlAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer1 == viewAnswerTrue){
                    rlAnswer1.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(true);
                }else {
                    rlAnswer1.setBackgroundColor(Color.parseColor("#FF0000"));
                    viewAnswerTrue.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(false);
                }
                tvTag.setText(pokemon.getTag());
                disableClick(rlAnswer2, rlAnswer3, rlAnswer4);
            }
        });
        rlAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer2 == viewAnswerTrue){
                    rlAnswer2.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(true);
                }else {
                    rlAnswer2.setBackgroundColor(Color.parseColor("#FF0000"));
                    viewAnswerTrue.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(false);
                }
                tvTag.setText(pokemon.getTag());
                disableClick(rlAnswer1, rlAnswer3, rlAnswer4);
            }
        });
        rlAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer3 == viewAnswerTrue){
                    rlAnswer3.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(true);
                }else {
                    rlAnswer3.setBackgroundColor(Color.parseColor("#FF0000"));
                    viewAnswerTrue.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(false);
                }
                tvTag.setText(pokemon.getTag());
                disableClick(rlAnswer1, rlAnswer2, rlAnswer4);
            }
        });
        rlAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlAnswer4 == viewAnswerTrue){
                    rlAnswer4.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(true);
                }else {
                    rlAnswer4.setBackgroundColor(Color.parseColor("#FF0000"));
                    viewAnswerTrue.setBackgroundColor(Color.parseColor("#32CD32"));
                    moveToNextQuestion(false);
                }
                tvTag.setText(pokemon.getTag());
                disableClick(rlAnswer1, rlAnswer2, rlAnswer3);
            }
        });
    }


    private View setupUIFromPokemon(Pokemon pokemon, int position){
        try {
            InputStream ims = getActivity().getAssets().open(pokemon.getImg());
            Drawable d = Drawable.createFromStream(ims, null);
            ivQuestion.setImageDrawable(d);
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

    private void moveToNextQuestion(final boolean isTrue){
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isTrue){
                    changeFragment(new GamePlayFragment());
                    ((MainActivity)getActivity()).setScore(((MainActivity)getActivity()).getScore() + 1);
                }else {
                    changeFragment(new HomeFragment());
                    if (((MainActivity)getActivity()).getScore() >= ((MainActivity)getActivity()).getHighScore()){
                        ((MainActivity)getActivity()).setHighScore((((MainActivity)getActivity()).getScore()));
                    }else;
                }
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

    private void changeFragment(Fragment fragment) {
        this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).addToBackStack(null).commit();
    }
}
