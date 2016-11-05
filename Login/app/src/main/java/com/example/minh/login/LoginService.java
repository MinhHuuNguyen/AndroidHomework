package com.example.minh.login;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Minh on 11/5/2016.
 */

public interface LoginService {
    @POST("/api/login")
    Call<Result> login(@Body RequestBody body);
}
