package com.dasb.brandonmilambo.loginform.interfaces;

public interface AuthenticationListener {
    // creating a dialog with the webview where the login happens and we get an access token
    void onCodeReceived(String auth_token);
}
