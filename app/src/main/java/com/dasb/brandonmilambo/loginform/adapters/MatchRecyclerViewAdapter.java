package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.model.match.GsonMatch;
import com.dasb.brandonmilambo.loginform.viewHolder.LoadingMatchViewHolder;
import com.dasb.brandonmilambo.loginform.viewHolder.MatchViewHolder;

import java.util.List;

public class MatchRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<GsonMatch> matchesData;
    /***shimmer implementation**/

    private boolean isLoading = true;//default behaviour will always be loading screen before the data is pulled
    private static final int LOADING_DUMMY_CELL_COUNT = 20;//amount of dummy cell we will display
    private static final int LOADING_CELL_TYPE = 0;
    private static final int MATCH_DAY_CELL = 1;


    public MatchRecyclerViewAdapter(Context context) {
        this.context = context;

    }

    public void setMatchesData(List<GsonMatch> matchesData) {
        this.matchesData = matchesData;
        isLoading = false;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (isLoading) {
            return LOADING_DUMMY_CELL_COUNT;
        } else {
            return matchesData.size();
        }
    }

    @Override
    public int getItemViewType(int position) {// return the int of real data view type or fake data view type
        if (isLoading) {
            return LOADING_CELL_TYPE;
        } else {
            return MATCH_DAY_CELL;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        /**
         * Inflate layout bind the Layout to the view.
         *
         */
        if (viewType == LOADING_CELL_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_match_card_place_holder, viewGroup, false);
            return new LoadingMatchViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_match_card, viewGroup, false);


            return new MatchViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if (getItemViewType(position) == MATCH_DAY_CELL) {
            MatchViewHolder matchViewHolder = (MatchViewHolder) viewHolder;
            GsonMatch gsonMatch = matchesData.get(position);


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

        } else {


        }

    }


}
