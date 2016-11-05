package com.example.minh.dailyquote.Models;

import io.realm.RealmObject;

/**
 * Created by Minh on 10/29/2016.
 */

public class Quote extends RealmObject{
    private int id;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Quote(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Quote create (String title, String content, int id){
        Quote quote = new Quote();
        quote.content = content;
        quote.title = title;
        quote.id = id;
        return quote;
    }
}
