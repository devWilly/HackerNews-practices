package com.devwilly.retrofit_java;

import com.devwilly.retrofit_java.api.ApiService;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String API_SERVICE_URL = " https://hacker-news.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView storiesView = findViewById(R.id.stories_text_id);
        final StringBuffer sb = new StringBuffer();

        Call<List<Integer>> topStoriesListResponse = getApiService().getTopStories();
        topStoriesListResponse.enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                List<Integer> list = response.body();
                sb.append(Html.fromHtml(getString(R.string.top_stories)));

                for (Integer item: list) {
                    sb.append('\n').append(item);
                }

                storiesView.setText(sb.toString());
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {

            }
        });

        Call<List<Integer>> newStoriesListResponse = getApiService().getNewStories();
        newStoriesListResponse.enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                List<Integer> list = response.body();
                sb.append('\n').append(getString(R.string.new_stories));

                for (Integer item: list) {
                    sb.append('\n').append(item);
                }

                storiesView.setText(sb.toString());
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {

            }
        });

    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    private ApiService getApiService() {
        return getRetrofit().create(ApiService.class);
    }
}
