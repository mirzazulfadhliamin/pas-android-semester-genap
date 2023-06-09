package com.example.pasandroidsemester2.rv_adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasandroidsemester2.DetailActivity;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.ListRowItemBinding;
import com.example.pasandroidsemester2.responses.library.LibraryMediaListItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<LibraryMediaListItem> localDataSet;

    public ListAdapter(ArrayList<LibraryMediaListItem> dataset) {
        this.localDataSet = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = localDataSet.get(position).getMedia().getTitle().getRomaji();
        String posterUrl = localDataSet.get(position).getMedia().getCoverImage().getLarge();
        String status = localDataSet.get(position).getStatus();
        int mediaId = localDataSet.get(position).getMedia().getId();

        holder.binding.tvTitle.setText(title);
        holder.binding.tvStatus.setText(status);

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
        ListRowItemBinding binding;
        public ViewHolder(ListRowItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
