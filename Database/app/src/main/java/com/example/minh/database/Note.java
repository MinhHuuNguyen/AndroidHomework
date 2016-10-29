package com.example.minh.database;

/**
 * Created by Minh on 10/29/2016.
 */

public class Note {
    private String title;
    private String content;
    private String date;
    private int id;

    public Note(String title, String content, String date, int id) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.id = id;
    }

    public Note(String title, String content, String time_created){
        this(title, content, time_created, -1);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
