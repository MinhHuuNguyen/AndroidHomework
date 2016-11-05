package com.example.minh.dailyquote;

import android.app.Application;
import android.util.Log;

import com.example.minh.dailyquote.Managers.DbContext;
import com.example.minh.dailyquote.Managers.FileManager;
import com.example.minh.dailyquote.Managers.NetworkManager;
import com.example.minh.dailyquote.Managers.Preferences;
import com.example.minh.dailyquote.Models.Quote;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Minh on 10/25/2016.
 */

public class QuoteApplication extends Application {

    private static final String TAG = QuoteApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(this);
        NetworkManager.init(this);
        FileManager.init(this);
        DbContext.init(this);
        //initImageLoader();
        if (NetworkManager.getInstance().isConnectedToInternet()){
            Log.d(TAG, "connected");
        }else{
            Log.d(TAG, " not connected");
        }
    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
