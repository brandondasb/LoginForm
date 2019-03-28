package com.dasb.brandonmilambo.loginform.view;

import android.support.v4.app.Fragment;

import com.dasb.brandonmilambo.loginform.interfaces.UpdateBottomNavListener;

public abstract class BaseNavFragment extends Fragment {
    protected UpdateBottomNavListener updateBottomNavListener;

    public void setUpdateBottomNavListener(UpdateBottomNavListener updateBottomNavListener) {
        this.updateBottomNavListener = updateBottomNavListener;
    }
}
