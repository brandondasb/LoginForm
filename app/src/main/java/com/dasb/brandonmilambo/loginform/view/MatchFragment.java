package com.dasb.brandonmilambo.loginform.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.interfaces.MatchesCallback;
import com.dasb.brandonmilambo.loginform.model.BottomNavState;
import com.dasb.brandonmilambo.loginform.model.match.GsonMatchesResponse;
import com.dasb.brandonmilambo.loginform.presenter.MatchPresenter;
import com.dasb.brandonmilambo.loginform.repo.FootballDataRepo;

public class MatchFragment extends BaseNavFragment {

    private MatchPresenter matchPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_match, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateBottomNavListener.updateBottomNav(BottomNavState.MATCH);
        matchPresenter = new MatchPresenter(view);
        FootballDataRepo footballDataRepo = new FootballDataRepo();
        footballDataRepo.getMatchDay("2021", matchesCallback);

    }

    private MatchesCallback matchesCallback = new MatchesCallback() {
        @Override
        public void loadMatchesData(GsonMatchesResponse response) {
            matchPresenter.loadMatch(response.getMatches());

        }
    };
}
