package com.dasb.brandonmilambo.loginform.repo;

import android.util.Log;

import com.dasb.brandonmilambo.loginform.api.FootballDataFixtureAPI;
import com.dasb.brandonmilambo.loginform.model.fixtures.GsonSeasonRounds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FixtureFootballDataRepo {
    private static final String BASE_URL = "https://server1.api-football.com/";
    private static final String AUTH_TOKEN = "5e70f85ab4ccda4eefd6e7914aaff466";

    private FootballDataFixtureAPI footballDataFixtureAPI;

    public FixtureFootballDataRepo() {
        configureRetroFit();
    }

    public void getCurrentFixture() {
        footballDataFixtureAPI.getCurrentFixture().enqueue(new Callback<GsonSeasonRounds>() {
            @Override
            public void onResponse(Call<GsonSeasonRounds> call, retrofit2.Response<GsonSeasonRounds> response) {
                Log.e("###", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<GsonSeasonRounds> call, Throwable t) {

            }
        });

    }

    private void configureRetroFit() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(configureAuthInterceptor())
                .build();
        this.footballDataFixtureAPI = retrofit.create(FootballDataFixtureAPI.class);

    }

    private OkHttpClient configureAuthInterceptor() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder().header("X-RapidAPI-Key", AUTH_TOKEN);
                builder.addHeader("Accept", "application/json");
                Request authoriseRequest = builder.build();
                return chain.proceed(authoriseRequest);
            }
        }).build();
    }
}
