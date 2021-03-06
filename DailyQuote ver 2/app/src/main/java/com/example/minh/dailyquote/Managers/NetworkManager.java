package com.example.minh.dailyquote.Managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Minh on 10/25/2016.
 */

public class NetworkManager {
    private ConnectivityManager connectivityManager;
    private NetworkManager(Context context){
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
    public boolean isConnectedToInternet(){
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }
    private static NetworkManager instance;
    public static NetworkManager getInstance(){
        return instance;
    }
    public static void init(Context context){
        instance = new NetworkManager(context);
    }
}
