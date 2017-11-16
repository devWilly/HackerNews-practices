package com.devwilly.retrofit_java.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Willy on 16/11/2017.
 */

public interface ApiService {

    @GET("v0/topstories.json?print=pretty")
    Call<List<Integer>> getTopStories();

    @GET("v0/newstories.json?print=pretty")
    Call<List<Integer>> getNewStories();

    @GET("v0/beststories.json?print=pretty")
    Call<List<Integer>> getBestStories();
}
