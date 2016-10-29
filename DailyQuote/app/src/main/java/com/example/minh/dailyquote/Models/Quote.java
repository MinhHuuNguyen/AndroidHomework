package com.example.minh.dailyquote.Models;

import android.content.Context;

import com.example.minh.dailyquote.Managers.DbHelper;

/**
 * Created by Minh on 10/29/2016.
 */

public class Quote {
    private int id;
    private String title;
    private String content;

    public Quote(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Quote(String title, String content){
        this(-1, title, content);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", id, title, content);
    }
}
