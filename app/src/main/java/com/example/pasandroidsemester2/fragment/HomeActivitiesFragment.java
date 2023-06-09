package com.example.pasandroidsemester2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import com.example.pasandroidsemester2.databinding.FragmentHomeActivitiesBinding;
import com.example.pasandroidsemester2.queries.GlobalActivityQuery;
import com.example.pasandroidsemester2.responses.global_activity.GlobalActivitiesItem;
import com.example.pasandroidsemester2.responses.global_activity.ResponseGetGlobalActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivitiesFragment extends Fragment {
    FragmentHomeActivitiesBinding binding;
    ArrayList<GlobalActivitiesItem> rvData = new ArrayList<>();
    Preferences pref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeActivitiesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        pref = new Preferences(getContext());
        setContent();

        return view;
    }

    private void setContent() {
        String authToken = pref.getAuthToken();
        GlobalActivityQuery activityQuery = new GlobalActivityQuery();

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseGetGlobalActivity> call = apiService.getGlobalActivities("Bearer "+authToken, activityQuery);
        call.enqueue(new Callback<ResponseGetGlobalActivity>() {
            @Override
            public void onResponse(Call<ResponseGetGlobalActivity> call, Response<ResponseGetGlobalActivity> response) {
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
                    Log.e("PROFILE-ERROR", error);
                    return;
                }

                String status = response.body().getData().getPage().getActivities().get(0).getStatus();
                Toast.makeText(getContext(), status, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseGetGlobalActivity> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}