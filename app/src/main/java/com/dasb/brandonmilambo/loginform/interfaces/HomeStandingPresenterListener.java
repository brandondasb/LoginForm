package com.dasb.brandonmilambo.loginform.interfaces;

/**
 * Defines the contract between the  view {@link com.dasb.brandonmilambo.loginform.view.HomeFragment}
 * and the Presenter {@link com.dasb.brandonmilambo.loginform.presenter.HomeStandingPresenter}
 *
 */
public interface HomeStandingPresenterListener {
    void getData(int spinnerItemPosition);
}
