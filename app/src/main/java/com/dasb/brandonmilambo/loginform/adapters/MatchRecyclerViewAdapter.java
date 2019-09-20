package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.model.match.GsonMatch;
import com.dasb.brandonmilambo.loginform.viewHolder.MatchViewHolder;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class MatchRecyclerViewAdapter extends RecyclerView.Adapter<MatchViewHolder> {
    private Context context;
    private List<GsonMatch> matchesData;
    private boolean isLoading = true;



    private static final int LOADING_CELL_TYPE = 0;
    private static final int MATCH_DAY_CELL = 1;

    public MatchRecyclerViewAdapter(Context context, List<GsonMatch> matchesData) {
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

//    @Override
//    public int getItemViewType(int position) {
//
//    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int position) {

        GsonMatch gsonMatch = matchesData.get(position);
        //GsonSeason gsonSeason = seasonData.get(position);


        String utcDate = String.valueOf(gsonMatch.getUtcDate());
        String status = String.valueOf(gsonMatch.getStatus());
        String matchday = String.valueOf(gsonMatch.getMatchday());
        String lastUpdated = String.valueOf(gsonMatch.getLastUpdated());


        //binding to view holder
        matchViewHolder.getMatchday().setText(matchday);
        matchViewHolder.getHometeam().setText(gsonMatch.getHomeTeam().getName());
        matchViewHolder.getAwayTeam().setText(gsonMatch.getAwayTeam().getName());
        /** Full time score**/
        matchViewHolder.getScoreHomeFullTime().setText(String.valueOf(gsonMatch.getScore().getFullTime().getHomeTeam()));
        matchViewHolder.getScoreAwayFullTime().setText(String.valueOf(gsonMatch.getScore().getFullTime().getAwayTeam()));
        /**Half time score**/
        matchViewHolder.getScoreHomeFullTime().setText(String.valueOf(gsonMatch.getScore().getHalfTime().getHomeTeam()));
        matchViewHolder.getScoreHomeFullTime().setText(String.valueOf(gsonMatch.getScore().getHalfTime().getHomeTeam()));

        //
       // matchViewHolder.getUtcDate().setText(utcDate);
        //  matchViewHolder.getLastUpdated().setText(lastUpdated);
       // matchViewHolder.getStatus().setText(status);
      //  matchViewHolder.getCurrrentMatchday().setText(currentMatchday);

    }

    @Override
    public int getItemCount() {
        return matchesData.size();
    }

    public void setData(List<GsonMatch> matchData) {
        isLoading = false;
    }
}
