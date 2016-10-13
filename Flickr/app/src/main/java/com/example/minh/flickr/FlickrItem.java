package com.example.minh.flickr;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Minh on 10/13/2016.
 */
public class FlickrItem {

    private String title;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public Media getMedia() {
        return media;
    }

    private String link;

    @SerializedName("date_taken")
    private String dateTaken;

    private Media media;

    public String getImageLink(){
        return media.getLink();
    }
    private class Media {
        @SerializedName("m")
        private String link;

        public String getLink() {
            return link;
        }
    }
}
