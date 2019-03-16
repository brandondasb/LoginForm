package com.dasb.brandonmilambo.loginform;

import com.dasb.brandonmilambo.loginform.model.LoginCredentials;
import com.dasb.brandonmilambo.loginform.model.LoginInteractor;

public class LoginPresenter implements Contract.LoginListener {
    private Contract.LoginView loginView;
    private LoginInteractor loginInteractor;
    public LoginPresenter(Contract.LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractor(this);
    }
    public void start(LoginCredentials credentials){
        loginView.ShowProgressBar();
loginInteractor.login(credentials);
    }

    @Override
    public void onSuccess() {
loginView.hideProgressBar();
loginView.onSuccess();
    }


    @Override
    public void onFailed(String message) {
        loginView.hideProgressBar();
        loginView.onFailed(message);


    }
}
