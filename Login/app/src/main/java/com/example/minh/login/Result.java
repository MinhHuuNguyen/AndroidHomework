package com.example.minh.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Minh on 11/5/2016.
 */

public class Result {
    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public boolean isSuccessful(){
        return ("1".equals(code));
    }
}
