package com.example.pasandroidsemester2.rv_adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.GlobalActivityRowItemBinding;
import com.example.pasandroidsemester2.responses.global_activity.GlobalActivitiesItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {
    private ArrayList<GlobalActivitiesItem> localDataSet;

    public ActivitiesAdapter(ArrayList<GlobalActivitiesItem> dataset) {
        this.localDataSet = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(GlobalActivityRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String status = localDataSet.get(position).getStatus();
        String name = localDataSet.get(position).getUser().getName();
        String title = localDataSet.get(position).getMedia().getTitle().getRomaji();
        String fullUpdate = "";

        if (!(status.equals("plans to watch") || status.equals("completed"))) {
            String progress = localDataSet.get(position).getProgress();
            int totalEpisodes = localDataSet.get(position).getMedia().getEpisodes();

            fullUpdate = String.format("%s %s %s out of %d of %s", name, status, progress, totalEpisodes, title);
        } else {
            fullUpdate = String.format("%s %s %s", name, status, title);
        }

        String posterUrl = localDataSet.get(position).getMedia().getCoverImage().getLarge();
        String avatarUrl = localDataSet.get(position).getUser().getAvatar().getMedium();
        Log.e("ACTIVITIES-DEBUG", Integer.toString(position));

        holder.binding.tvActivityText.setText(fullUpdate);

        Picasso.get()
                .load(posterUrl)
                .placeholder(R.color.backgorund_nv)
                .error(R.color.black_suram)
                .into(holder.binding.ivPoster);

        Picasso.get()
                .load(avatarUrl)
                .placeholder(R.color.backgorund_nv)
                .error(R.color.black_suram)
                .into(holder.binding.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        GlobalActivityRowItemBinding binding;
        public ViewHolder(GlobalActivityRowItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
