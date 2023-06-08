package com.example.pasandroidsemester2.rv_adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasandroidsemester2.DetailActivity;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.SearchRowItemBinding;
import com.example.pasandroidsemester2.responses.search.SearchMediaItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private ArrayList<SearchMediaItem> localDataSet;

    public SearchAdapter(ArrayList<SearchMediaItem> dataset) {
        this.localDataSet = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(SearchRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = localDataSet.get(position).getTitle().getRomaji();
        String posterUrl = localDataSet.get(position).getCoverImage().getLarge();
        int mediaId = localDataSet.get(position).getId();

        holder.binding.tvTitle.setText(title);

        Picasso.get()
                .load(posterUrl)
                .placeholder(R.color.backgorund_nv)
                .error(R.color.black_suram)
                .into(holder.binding.ivPoster);

        holder.binding.searchCard.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("media_id", mediaId);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        SearchRowItemBinding binding;
        public ViewHolder(SearchRowItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
