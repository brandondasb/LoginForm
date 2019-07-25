package com.dasb.brandonmilambo.loginform.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.dasb.brandonmilambo.loginform.R;
import com.pixplicity.sharp.Sharp;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkUtils {

        private static OkHttpClient httpClient;

        public static void fetchSvg(final Context context, String url, final ImageView target) {
            if (httpClient == null) {
                // Use cache for performance and basic offline capability
                httpClient = new OkHttpClient.Builder()
                        .cache(new Cache(context.getCacheDir(), 5 * 1024 * 1014))
                        .build();
            }

            Request request = new Request.Builder().url(url).build();
            httpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Drawable fallBackImage = context.getDrawable(R.drawable.ic_aston_villa_logo);
                    target.setImageDrawable(fallBackImage);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    InputStream stream = response.body().byteStream();
                    Sharp.loadInputStream(stream).into(target);
                    stream.close();
                }
            });
        }
    }