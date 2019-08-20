package com.dasb.brandonmilambo.loginform.api;

import com.dasb.brandonmilambo.loginform.model.match.GsonMatchesResponse;
import com.dasb.brandonmilambo.loginform.model.table.GsonStandingsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FootballDataApi {
    @GET("competitions/{id}/standings")
    Call<GsonStandingsResponse> getStandings(@Path("id") String standingId, @Query("season") String season);

    @GET("competitions/{id}/matches")
    Call<GsonMatchesResponse> getMatches(@Path("id") String standingId);
}
