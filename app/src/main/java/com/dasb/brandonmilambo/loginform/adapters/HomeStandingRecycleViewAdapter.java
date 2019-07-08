package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.caverock.androidsvg.SVG;
import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.glide.SVGDecoder;
import com.dasb.brandonmilambo.loginform.glide.SvgDrawableTranscoder;
import com.dasb.brandonmilambo.loginform.glide.SvgSoftwareLayerSetter;
import com.dasb.brandonmilambo.loginform.model.GsonTeamStandings;
import com.dasb.brandonmilambo.loginform.viewHolder.TeamViewHolder;

import java.io.InputStream;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class HomeStandingRecycleViewAdapter extends RecyclerView.Adapter<TeamViewHolder>{

    private Context context;
    private List<GsonTeamStandings> teamStandingData;

    public HomeStandingRecycleViewAdapter(Context context, List<GsonTeamStandings> teamStandingDate) {

        this.context = context;
        this.teamStandingData = teamStandingDate;


    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_team_card,viewGroup,false);// crate a view of layout

        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder, int position) {
        GsonTeamStandings teamStanding = teamStandingData.get(position);
        String teamname = teamStanding.getTeam().getName();
        String teamCrestUrl = teamStanding.getTeam().getCrestURL();
        teamViewHolder.getNameTextView().setText(teamname);


//        Glide
//                .with(context)
//                .load("https://www.clipartmax.com/png/middle/98-980462_manchester-united-3d-logo-png-manchester-united-soccer-logo.png")
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        e.getMessage();
//                        Log.e("TAG",e.getMessage());
//
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        return false;
//                    }
//                })
//                .centerCrop()
//                .into(teamViewHolder.getImageView());

//test
        GenericRequestBuilder<Uri,InputStream,SVG,PictureDrawable> requestBuilder =  Glide.with(context)
                .using(Glide.buildStreamModelLoader(Uri.class,context),InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SVGDecoder()))
                .decoder(new SVGDecoder())
                .error(R.drawable.ic_aston_villa_logo)
                .listener(new SvgSoftwareLayerSetter<Uri>());


        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .load(Uri.parse(teamCrestUrl))
                .into(teamViewHolder.getImageView());

    }



    @Override
    public int getItemCount() {
        return teamStandingData.size();
    }
}
