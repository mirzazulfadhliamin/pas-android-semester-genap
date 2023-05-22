package com.example.pasandroidsemester2;


import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {

    private List<Movie> localDataSet;

    public AnimeAdapter(List<Movie> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvAnimeTitle, tvReleaseDate, tvAnimeRating;
        private final ImageView imgAnimePoster;

        public ViewHolder(View view) {
            super(view);



            //Menyimpan lokasi text view dan foto di xmlnya agar bisa di set di lain kali
            tvAnimeTitle = view.findViewById(R.id.anime_name);
            tvReleaseDate = view.findViewById(R.id.anime_release_date);
            tvAnimeRating = view.findViewById(R.id.anime_rating);
            imgAnimePoster = view.findViewById(R.id.anime_poster);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {



        //
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}
