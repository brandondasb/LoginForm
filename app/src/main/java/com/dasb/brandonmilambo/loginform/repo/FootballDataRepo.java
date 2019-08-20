package com.dasb.brandonmilambo.loginform.repo;

import android.util.Log;

import com.dasb.brandonmilambo.loginform.api.FootballDataApi;
import com.dasb.brandonmilambo.loginform.interfaces.MatchesCallback;
import com.dasb.brandonmilambo.loginform.interfaces.StandingCallback;
import com.dasb.brandonmilambo.loginform.model.GsonMatchesResponse;
import com.dasb.brandonmilambo.loginform.model.GsonStandingsResponse;
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

public class FootballDataRepo {
    private static final String BASE_URL = "https://api.football-data.org/v2/";
    private static final String AUTH_TOKEN = "299e06bce9d84da784d0f3b25de7ed0c";


    private FootballDataApi footballApi;

    public FootballDataRepo() {
        configureRetroFit();

    }

    public void getStandingFordId(String id, String season, final StandingCallback standingCallback) {
        footballApi.getStandings(id, season).enqueue(new Callback<GsonStandingsResponse>() {
            @Override
            public void onResponse(Call<GsonStandingsResponse> call, retrofit2.Response<GsonStandingsResponse> response) {
                if (response.isSuccessful()) {
                    standingCallback.loadStandingData(response.body());

                } else {
                }
            }

            @Override
            public void onFailure(Call<GsonStandingsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * attempt make a second call pulling back matchday data
     */
    public void getMatchDay(String id, final MatchesCallback matchesCallback) {
        footballApi.getMatches(id).enqueue(new Callback<GsonMatchesResponse>() {
            @Override
            public void onResponse(Call<GsonMatchesResponse> call, retrofit2.Response<GsonMatchesResponse> response) {
                if (response.isSuccessful()) {
                    matchesCallback.loadMatchesData(response.body());
                } else {

                }
            }

            @Override
            public void onFailure(Call<GsonMatchesResponse> call, Throwable t) {
                t.printStackTrace();
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
        this.footballApi = retrofit.create(FootballDataApi.class);
    }

    private OkHttpClient configureAuthInterceptor() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder().header("X-Auth-Token", AUTH_TOKEN);
                Request authoriseRequest = builder.build();
                return chain.proceed(authoriseRequest);
            }
        }).build();
    }
}
