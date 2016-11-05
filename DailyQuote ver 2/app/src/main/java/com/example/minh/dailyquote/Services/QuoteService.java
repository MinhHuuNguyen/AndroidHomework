package com.example.minh.dailyquote.Services;

import com.example.minh.dailyquote.Models.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Minh on 11/5/2016.
 */

public interface QuoteService {
    @GET("posts?filter[orderby]=rand")
    Call<List<Quote>> getListQuote(@Query("filter[posts_per_page]") int number);
}