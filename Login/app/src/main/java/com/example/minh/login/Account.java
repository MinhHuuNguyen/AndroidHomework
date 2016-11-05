package com.example.minh.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Minh on 11/5/2016.
 */

public class Account {
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
