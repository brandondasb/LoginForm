package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.model.GsonScore;
import com.dasb.brandonmilambo.loginform.model.GsonTeamMatches;
import com.dasb.brandonmilambo.loginform.viewHolder.MatchViewHolder;

import java.util.List;

public class MatchRecyclerViewAdapter extends RecyclerView.Adapter<MatchViewHolder> {
    private Context context;
    private List<GsonTeamMatches> matchesData;

    public MatchRecyclerViewAdapter(Context context, List<GsonTeamMatches> matchesData) {
        this.context = context;
        this.matchesData = matchesData;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /**
         * Inflate layout bind the Layout to the view.
         *
         */
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_match_card, viewGroup, false);


        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int position) {
        GsonTeamMatches gsonTeamMatches = matchesData.get(position);


        String utcDate = String.valueOf(gsonTeamMatches.getUtcDate());
        String status = String.valueOf(gsonTeamMatches.getStatus());
        String matchday = String.valueOf(gsonTeamMatches.getMatchday());
        String lastUpdated= String.valueOf(gsonTeamMatches.getLastUpdated());

// TBC
         List homeTeam;
         List awayTeam;

         //binding to view holder
        matchViewHolder.getLastUpdated().setText(utcDate);
        matchViewHolder.getStatus().setText(status);
        matchViewHolder.getMatchday().setText(matchday);
        matchViewHolder.getLastUpdated().setText(lastUpdated);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
