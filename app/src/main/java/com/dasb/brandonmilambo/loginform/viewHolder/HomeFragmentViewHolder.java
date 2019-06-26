package com.dasb.brandonmilambo.loginform.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dasb.brandonmilambo.loginform.R;

public class HomeFragmentViewHolder {

    private RecyclerView recyclerView;

    public HomeFragmentViewHolder(View view) {
        this.recyclerView =  view.findViewById(R.id.home_fragment_recycleView);
    }

    //getter
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
