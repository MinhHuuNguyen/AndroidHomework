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


/**
 * A simple {@link Fragment} subclass.
 */
public class GamePlayFragment extends Fragment {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.iv_question)
    ImageView ivQuestion;

    public GamePlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_play, container, false);
        Pokemon pokemon = DbHelper.getInstance().selectRandomPokemon();
        String assetPath = "file:///android_asset/flags/";
        Log.d(TAG, pokemon.getImg().toString());
        Glide.with(this).load(Uri.parse("file:///android_asset/images/" + pokemon.getImg())).into(ivQuestion);
        return view;
    }

}
