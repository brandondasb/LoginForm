package com.dasb.brandonmilambo.loginform.interfaces;

import com.dasb.brandonmilambo.loginform.model.match.GsonMatchesResponse;

public interface MatchesCallback {
    void loadMatchesData(GsonMatchesResponse Response);

}
