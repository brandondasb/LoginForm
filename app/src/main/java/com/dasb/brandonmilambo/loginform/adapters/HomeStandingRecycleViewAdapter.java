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

public class HomeStandingRecycleViewAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    private Context context;
    private List<GsonTeamStandings> teamStandingData;

    public HomeStandingRecycleViewAdapter(Context context, List<GsonTeamStandings> teamStandingDate) {

        this.context = context;
        this.teamStandingData = teamStandingDate;


    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_team_card, viewGroup, false);// crate a view of layout

        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder, int position) {
        GsonTeamStandings teamStanding = teamStandingData.get(position);
       // String teamCrestUrl = "https://en.wikipedia.org/wiki/Wolverhampton_Wanderers_F.C.#/media/File:Wolverhampton_Wanderers.svg";

        String teamPosition = String.valueOf(teamStanding.getPosition());
        String teamname = teamStanding.getTeam().getName();
        String playedGames = String.valueOf(teamStanding.getPlayedGames());
        String won = String.valueOf(teamStanding.getWon());
        String lost = String.valueOf(teamStanding.getLost());
        String draw = String.valueOf(teamStanding.getDraw());
        String points = String.valueOf(teamStanding.getPoints());
        String goalsFor = String.valueOf(teamStanding.getGoalsFor());
        String goalAgainst = String.valueOf(teamStanding.getGoalsAgainst());
        String goalDifference = String.valueOf(teamStanding.getGoalDifference());


        teamViewHolder.getPostion().setText(teamPosition);
        teamViewHolder.getNameTextView().setText(teamname);
        teamViewHolder.getMatchPlayed().setText(playedGames);
        teamViewHolder.getWon().setText(won);
        teamViewHolder.getLost().setText(lost);
        teamViewHolder.getDraw().setText(draw);
        teamViewHolder.getPoints().setText(points);




    }


    @Override
    public int getItemCount() {
        return teamStandingData.size();
    }
}
