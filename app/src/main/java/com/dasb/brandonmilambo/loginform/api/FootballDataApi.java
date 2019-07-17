package com.dasb.brandonmilambo.loginform.api;

import com.dasb.brandonmilambo.loginform.model.GsonStandings;
import com.dasb.brandonmilambo.loginform.model.GsonStandingsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FootballDataApi {
    @GET("competitions/{id}/standings")
    Call<GsonStandingsResponse> getStandings(@Path("id") String standingId, @Query("season") String season);
}
