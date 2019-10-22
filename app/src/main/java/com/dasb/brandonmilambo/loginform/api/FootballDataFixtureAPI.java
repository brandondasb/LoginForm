package com.dasb.brandonmilambo.loginform.api;

import com.dasb.brandonmilambo.loginform.model.fixtures.GsonFixture;
import com.dasb.brandonmilambo.loginform.model.fixtures.GsonSeasonRounds;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FootballDataFixtureAPI {
    //TODO - substitute 2 for correct Premier League id
    @GET("fixtures/rounds/2/current")
    Call<GsonSeasonRounds> getCurrentFixture();

    @GET("fixtures/league/2/{round}")
    Call<GsonFixture> getSeasonRound(@Path("round") String round);


}
