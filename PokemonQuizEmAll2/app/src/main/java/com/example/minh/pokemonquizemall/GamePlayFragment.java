package com.example.minh.pokemonquizemall;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamePlayFragment extends Fragment {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.iv_question)
    ImageView ivQuestion;
    @BindView(R.id.iv_answer1)
    ImageView ivAnswer1;
    @BindView(R.id.iv_answer2)
    ImageView ivAnswer2;
    @BindView(R.id.iv_answer3)
    ImageView ivAnswer3;
    @BindView(R.id.iv_answer4)
    ImageView ivAnswer4;
    public GamePlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_play, container, false);
        Pokemon pokemon = DbHelper.getInstance().selectRandomPokemon();
        ButterKnife.bind(this, view);
        Log.d(TAG, pokemon.getImg());
        Glide.with(this).load("http://goo.gl/gEgYUd").into(ivQuestion);
        return view;
    }

}
