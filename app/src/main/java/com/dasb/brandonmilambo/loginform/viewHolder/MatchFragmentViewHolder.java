package com.dasb.brandonmilambo.loginform.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dasb.brandonmilambo.loginform.R;

public class MatchFragmentViewHolder {
    RecyclerView matchRecyclerView;
    /** Assigning recycler view object to XML**/
    public MatchFragmentViewHolder (View view){
        this.matchRecyclerView = view.findViewById(R.id.match_fragment_recyclerView);
    }
/** gen getter  to access this new object  in other classes**/
    public RecyclerView getMatchRecyclerView() {
        return matchRecyclerView;
    }

}
