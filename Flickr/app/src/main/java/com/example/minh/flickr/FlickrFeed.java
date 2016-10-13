package com.example.minh.flickr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minh on 10/13/2016.
 */
public class FlickrFeed {
    private String title;
    private ArrayList<FlickrItem> items;

    public List<FlickrItem> getItems() {
        return items;
    }

    public FlickrFeed(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
