package com.dasb.brandonmilambo.loginform.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.api.FootballDataApi;
import com.dasb.brandonmilambo.loginform.interfaces.StandingCallback;
import com.dasb.brandonmilambo.loginform.interfaces.UpdateBottomNavListener;
import com.dasb.brandonmilambo.loginform.model.BottomNavState;
import com.dasb.brandonmilambo.loginform.model.GsonStandingsResponse;
import com.dasb.brandonmilambo.loginform.repo.FootballDataRepo;

public class HomeFragment extends BaseNavFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateBottomNavListener.updateBottomNav(BottomNavState.HOME);

        FootballDataRepo footballDataRepo = new FootballDataRepo();
        footballDataRepo.getStandingFordId("2021",standingCallback);
    }
    private StandingCallback  standingCallback = new StandingCallback() {

        @Override
        public void loadStandingData(GsonStandingsResponse response) {

        }
    };
}
