package com.example.pasandroidsemester2.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pasandroidsemester2.ApiClient;
import com.example.pasandroidsemester2.ApiService;
import com.example.pasandroidsemester2.ErrorResponseChecker;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.FragmentHomeAnimeBinding;
import com.example.pasandroidsemester2.queries.RecommendationQuery;
import com.example.pasandroidsemester2.responses.recommendation.RecommendationsItem;
import com.example.pasandroidsemester2.responses.recommendation.ResponseGetRecommendation;
import com.example.pasandroidsemester2.rv_adapters.RecommendationAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAnimeFragment extends Fragment {
    FragmentHomeAnimeBinding binding;
    ArrayList<RecommendationsItem> rvData = new ArrayList<>();
    RecommendationAdapter recommendationAdapter;
    Preferences pref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeAnimeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        pref = new Preferences(getContext());
        recommendationAdapter = new RecommendationAdapter(rvData);
        binding.rvRecommendation.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.rvRecommendation.setAdapter(recommendationAdapter);
        setContent();

        return view;
    }

    private void setContent() {
        String authToken = pref.getAuthToken();
        RecommendationQuery query = new RecommendationQuery();

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseGetRecommendation> call = apiService.getRecommendation("Bearer "+authToken, query);
        call.enqueue(new Callback<ResponseGetRecommendation>() {
            @Override
            public void onResponse(Call<ResponseGetRecommendation> call, Response<ResponseGetRecommendation> response) {
                ErrorResponseChecker errorChecker = new ErrorResponseChecker(response);
                if (errorChecker.isBodyNull()) {
                    int errorCode = errorChecker.getCodeError();
                    String error = String.format(
                            "ERROR: %d: %s",
                            errorCode,
                            "Something went wrong while trying to send request to AniList");
                    // Protection against null context mfw
                    if (null != getContext()) {
                        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                    }
                    Log.e("RECOMMENDATIONS-ERROR", error);
                    return;
                }

                ArrayList<RecommendationsItem> datalist = response.body().getData().getPage().getRecommendations();
                rvData.clear();
                rvData.addAll(datalist);
                recommendationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseGetRecommendation> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}