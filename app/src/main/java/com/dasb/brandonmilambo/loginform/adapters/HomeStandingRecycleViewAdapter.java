package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.model.GsonTeamStandings;
import com.dasb.brandonmilambo.loginform.viewHolder.TeamViewHolder;

import java.util.List;

public class HomeStandingRecycleViewAdapter extends RecyclerView.Adapter<TeamViewHolder>{

    private Context context;
    private List<GsonTeamStandings> teamStandingData;

    public HomeStandingRecycleViewAdapter(Context context, List<GsonTeamStandings> teamStandingDate) {

        this.context = context;
        this.teamStandingData = teamStandingDate;


    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_team_card,viewGroup,false);// crate a view of layout

        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder, int position) {
        String teamname = teamStandingData.get(position).getTeam().getName();
        teamViewHolder.getNameTextView().setText(teamname);
    }



    @Override
    public int getItemCount() {
        return teamStandingData.size();
    }
}
