package com.dasb.brandonmilambo.loginform.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Spinner;

import com.dasb.brandonmilambo.loginform.R;

public class HomeFragmentViewHolder {

    private RecyclerView recyclerView;
    private Spinner spinner;

    /**
     * adding all XML in a view holder so we can have the ui set created separeatly forome ui class.
     * @param view
     */
    public HomeFragmentViewHolder(View view) {
        this.recyclerView =  view.findViewById(R.id.home_fragment_recycleView);
        this.spinner = view.findViewById(R.id.spinnerSeason);
    }

    //getter
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public Spinner getSpinner() {
        return spinner;
    }
}
