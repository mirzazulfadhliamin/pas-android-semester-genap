package com.example.pasandroidsemester2.rv_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.binding.tvTitle.setText(title);

        String posterUrl = localDataSet.get(position).getCoverImage().getLarge();
        Picasso.get()
                .load(posterUrl)
                .placeholder(R.color.backgorund_nv)
                .error(R.color.black_suram)
                .into(holder.binding.ivPoster);
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
