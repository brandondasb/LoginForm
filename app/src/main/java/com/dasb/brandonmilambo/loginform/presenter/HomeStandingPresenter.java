package com.dasb.brandonmilambo.loginform.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dasb.brandonmilambo.loginform.adapters.HomeStandingRecycleViewAdapter;
import com.dasb.brandonmilambo.loginform.model.GsonTeamStandings;
import com.dasb.brandonmilambo.loginform.viewHolder.HomeFragmentViewHolder;

import java.util.List;

public class HomeStandingPresenter {
    private Context context;
    private HomeFragmentViewHolder viewHolder;

    public HomeStandingPresenter(View view) {
        viewHolder = new HomeFragmentViewHolder(view);
        context = view.getContext();

    }

    public void Load(List<GsonTeamStandings> teamStandings) {

        viewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        HomeStandingRecycleViewAdapter homeStandingRecycleViewAdapter = new HomeStandingRecycleViewAdapter(context, teamStandings);
        viewHolder.getRecyclerView().setAdapter(homeStandingRecycleViewAdapter);
    }
}
