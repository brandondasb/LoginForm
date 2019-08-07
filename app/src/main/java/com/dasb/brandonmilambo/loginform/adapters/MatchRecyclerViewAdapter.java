package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
