package com.example.minh.dailyquote.Managers;

import android.content.Context;

import com.example.minh.dailyquote.Models.Quote;

import java.util.List;
import java.util.Random;

import io.realm.Realm;

/**
 * Created by Minh on 11/5/2016.
 */

public class DbContext {
    private Realm realm;
    private static DbContext instance;

    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbContext(context);
    }

    private DbContext(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void addQuote(Quote quote){
        realm.beginTransaction();
        realm.copyToRealm(quote);
        realm.commitTransaction();
    }

    public Quote getRandomQuote(){
        List<Quote> quoteList = realm.where(Quote.class).findAll();
        return quoteList.get(new Random().nextInt(quoteList.size()));
    }

}
