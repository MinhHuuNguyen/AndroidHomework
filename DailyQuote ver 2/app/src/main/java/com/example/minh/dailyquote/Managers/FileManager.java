package com.example.minh.dailyquote.Managers;

import android.content.Context;
import android.graphics.Bitmap;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;

/**
 * Created by Minh on 10/25/2016.
 */

public class FileManager {
    private Storage storage;
    private final static  String IMAGE_DIRECTORY = "images";
    private final static String IMAGE_NAME = "%s.png";
    public FileManager (Context context){
        storage = SimpleStorage.getInternalStorage(context);
    }

    public void createImage(Bitmap bitmap, String fileName){
        storage.createFile(IMAGE_DIRECTORY, fileName, bitmap);
    }
    public File loadImageFile(String fileName){
        return storage.getFile(IMAGE_DIRECTORY, fileName);
    }

    public void createImage (Bitmap bitmap, int index){
        createImage(bitmap, String.format(IMAGE_NAME, index));
    }
    public File loadImageFile (int index){
        return loadImageFile(String.format(IMAGE_NAME, index));
    }
    private static FileManager instance;

    public static FileManager getInstance() {
        return instance;
    }
    public static void init(Context context){
        instance = new FileManager(context);
    }
}
