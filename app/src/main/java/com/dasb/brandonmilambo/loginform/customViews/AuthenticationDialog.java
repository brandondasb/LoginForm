package com.dasb.brandonmilambo.loginform.customViews;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.interfaces.AuthenticationListener;

public class AuthenticationDialog extends Dialog {
    private WebView webView;

    //IG second set up
    private final String redirect_url;
    private final String request_url;
    private AuthenticationListener listener;


    public AuthenticationDialog(@NonNull Context context,
                                AuthenticationListener listener) {
        super(context);
        // this.context= context;
        this.listener = listener;
        this.redirect_url =
                context.getResources().getString(R.string.redirect_url);
        this.request_url =
                context.getResources().getString(R.string.base_url) +
                        "oauth/authorize/?client_id=" +
                        context.getResources().getString(R.string.client_id) +
                        "&redirect_uri=" + redirect_url +
                        "&response_type=token&display=touch&scope=public_content";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.auth_dialog);


        //  initializeWebView();


        //private void initializeWebView() {
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(request_url);
        webView.setWebViewClient(webViewClient);
    }

        WebViewClient webViewClient = new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith(redirect_url)) {
                    AuthenticationDialog.this.dismiss();
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //need to check here

                if (url.contains("access_token=")) {
                    Uri uri = Uri.EMPTY.parse(url);
                    String access_token = uri.getEncodedFragment();
                    access_token = access_token.substring(access_token.lastIndexOf("=") + 1);
                    listener.onTokenReceived(access_token);
                }
            }
        };
    }
