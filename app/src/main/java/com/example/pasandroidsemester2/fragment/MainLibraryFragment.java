package com.example.pasandroidsemester2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pasandroidsemester2.ApiClient;
import com.example.pasandroidsemester2.ApiService;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.FragmentMainLibraryBinding;
import com.example.pasandroidsemester2.queries.ListQuery;
import com.example.pasandroidsemester2.responses.library.LibraryMediaListItem;
import com.example.pasandroidsemester2.responses.library.ResponseGetList;
import com.example.pasandroidsemester2.rv_adapters.ListAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainLibraryFragment extends Fragment {
    FragmentMainLibraryBinding binding;
    Preferences pref;
    ListAdapter listAdapter;
    ArrayList<LibraryMediaListItem> rvData = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        *
        * TODO: Jangan lupa implement safeguard buat null!!!
        *
        */
        binding = FragmentMainLibraryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        listAdapter = new ListAdapter(rvData);
        binding.rvLibrary.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rvLibrary.setAdapter(listAdapter);

        pref = new Preferences(getContext());
        setContent();

        return view;
    }

    private void setContent() {
        int id = pref.getUserId();
        if (id < 0) {
            Toast.makeText(getContext(), "ERROR: No user ID", Toast.LENGTH_SHORT).show();
            return;
        }
        String authToken = pref.getAuthToken();
        ListQuery listQuery = new ListQuery(id);

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseGetList> call = apiService.getList("Bearer "+authToken, listQuery);
        call.enqueue(new Callback<ResponseGetList>() {
            @Override
            public void onResponse(Call<ResponseGetList> call, Response<ResponseGetList> response) {
                ArrayList<LibraryMediaListItem> datalist = response.body().getData().getPage().getMediaList();
                rvData.clear();
                rvData.addAll(datalist);
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseGetList> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}