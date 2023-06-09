package com.example.pasandroidsemester2.rv_adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasandroidsemester2.DetailActivity;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.RecommendationRowItemBinding;
import com.example.pasandroidsemester2.databinding.SearchRowItemBinding;
import com.example.pasandroidsemester2.responses.recommendation.RecommendationsItem;
import com.example.pasandroidsemester2.responses.search.SearchMediaItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.ViewHolder> {
    private ArrayList<RecommendationsItem> localDataSet;

    public RecommendationAdapter(ArrayList<RecommendationsItem> dataset) {
        this.localDataSet = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RecommendationRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = localDataSet.get(position).getMediaRecommendation().getTitle().getRomaji();
        String posterUrl = localDataSet.get(position).getMediaRecommendation().getCoverImage().getLarge();
        int id = localDataSet.get(position).getMediaRecommendation().getId();

        holder.binding.tvTitle.setText(title);

        Picasso.get()
                .load(posterUrl)
                .placeholder(R.color.backgorund_nv)
                .error(R.color.black_suram)
                .into(holder.binding.ivPoster);

        holder.binding.recommendationCard.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("media_id", id);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecommendationRowItemBinding binding;
        public ViewHolder(RecommendationRowItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
