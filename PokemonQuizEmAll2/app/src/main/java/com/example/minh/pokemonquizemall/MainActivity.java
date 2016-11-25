package com.example.minh.pokemonquizemall;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public int score;
    public int highScore;
    public MediaPlayer homeMediaPlayer;
    public MediaPlayer playMediaPLayer;
    public boolean isPlayedMusic = true;
    public boolean isPlayedSound = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeMediaPlayer = MediaPlayer.create(this,R.raw.homemusic);
        playMediaPLayer = MediaPlayer.create(this, R.raw.playmusic);
        DbHelper.init(this);
        changeFragment(new HomeFragment());
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("HighScorePreference",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("highscore", (this.getHighScore()));
        editor.commit();
        setHighScore(sharedPreferences.getInt("highscore", -1));
    }

    public MediaPlayer getHomeMediaPlayer() {
        return homeMediaPlayer;
    }

    public void setHomeMediaPlayer(MediaPlayer homeMediaPlayer) {
        this.homeMediaPlayer = homeMediaPlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).addToBackStack(null).commit();
    }
}
