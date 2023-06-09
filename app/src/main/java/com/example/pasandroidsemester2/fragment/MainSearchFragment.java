package com.example.pasandroidsemester2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.pasandroidsemester2.ApiClient;
import com.example.pasandroidsemester2.ApiService;
import com.example.pasandroidsemester2.ErrorResponseChecker;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.FragmentMainSearchBinding;
import com.example.pasandroidsemester2.queries.SearchQuery;
import com.example.pasandroidsemester2.responses.search.ResponseGetSearch;
import com.example.pasandroidsemester2.responses.search.SearchMediaItem;
import com.example.pasandroidsemester2.rv_adapters.SearchAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainSearchFragment extends Fragment {

    FragmentMainSearchBinding binding;
    Preferences pref;
    ArrayList<SearchMediaItem> rvData = new ArrayList<>();
    SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainSearchBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        pref = new Preferences(getContext());

        searchAdapter = new SearchAdapter(rvData);
        binding.rvSearch.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rvSearch.setAdapter(searchAdapter);

        binding.searchView.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                getSearchResults(binding.searchView.getText().toString());
                return true;
            }
            return false;
        });
        return view;
    }

    private void getSearchResults(String keyword) {
        Toast.makeText(getContext(), keyword, Toast.LENGTH_SHORT).show();
        SearchQuery query = new SearchQuery(keyword);

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseGetSearch> call = apiService.getSearch("Bearer " + pref.getAuthToken(), query);
        call.enqueue(new Callback<ResponseGetSearch>() {
            @Override
            public void onResponse(Call<ResponseGetSearch> call, Response<ResponseGetSearch> response) {
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

                ArrayList<SearchMediaItem> datalist = response.body().getData().getPage().getMedia();
                Log.d("SEARCH-DEBUG", Integer.toString(datalist.size()));
                rvData.clear();
                rvData.addAll(datalist);
                searchAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseGetSearch> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}