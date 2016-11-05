package com.example.minh.dailyquote;

import android.app.DownloadManager;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minh.dailyquote.Constants.Constants;
import com.example.minh.dailyquote.Fragment.LoginFragment;
import com.example.minh.dailyquote.Fragment.QuoteFragment;
import com.example.minh.dailyquote.JsonModel.QuotesJsonModel;
import com.example.minh.dailyquote.Managers.Preferences;
import com.example.minh.dailyquote.Models.FragmentEvent;
import com.example.minh.dailyquote.Models.Quote;
import com.example.minh.dailyquote.Services.UnplashDownloadService;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        if (Preferences.getInstance().getUsername() == null) {
            changeFragment(new LoginFragment(), false);
        } else {
            changeFragment(new QuoteFragment(), false);
        }
        Intent intent = new Intent(this, UnplashDownloadService.class);
        startService(intent);
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent){
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackstack());

    }

    public void changeFragment(android.support.v4.app.Fragment fragment, boolean addToBackstack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment);
        if(addToBackstack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
