package com.dasb.brandonmilambo.loginform.interfaces;

import com.dasb.brandonmilambo.loginform.model.GsonMatchesResponse;
import com.dasb.brandonmilambo.loginform.model.GsonStandingsResponse;

public interface StandingCallback {
    void loadStandingData(GsonStandingsResponse response);


}
