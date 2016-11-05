package com.example.minh.dailyquote.Services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.minh.dailyquote.Constants.Constants;
import com.example.minh.dailyquote.Managers.FileManager;
import com.example.minh.dailyquote.Managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Minh on 10/29/2016.
 */

public class UnplashDownloadService extends IntentService {

    private static final String TAG = UnplashDownloadService.class.toString();
    private static final int IMAGE_NUMBER = 10;

    public UnplashDownloadService() {
        super("UnplashDownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        for (int i = 1; i <= IMAGE_NUMBER; i++){
            Log.d(TAG, String.format("No %s", i));
            Log.d(TAG, "Downloading");
            Bitmap bitmap = ImageLoader.getInstance().loadImageSync(Constants.UNPLASH_API);
            if (bitmap == null) {
                i--;
                continue;
            }
            Log.d(TAG, "Download Complete");
            Log.d(TAG, "Saving");
            FileManager.getInstance().createImage(bitmap, i);
            Log.d(TAG, "Save Complete");
            Preferences.getInstance().putImageCount(i + 1);
        }

    }
}
