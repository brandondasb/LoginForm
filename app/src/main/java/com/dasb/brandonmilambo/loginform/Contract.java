package com.dasb.brandonmilambo.loginform;

public interface Contract {
    interface LoginView{
        void  ShowProgressBar();// show and hide the progress bar
        void  hideProgressBar();
        void onSuccess();
        void onFailed(String message);

         // we will implement this in the view (login activity)
    }
    interface  LoginListener{
        void onSuccess();
        void onFailed(String message);
        // this will be implemented in the presenter class

    }
}
