package com.example.pasandroidsemester2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pasandroidsemester2.ApiClient;
import com.example.pasandroidsemester2.ApiService;
import com.example.pasandroidsemester2.ErrorResponseChecker;
import com.example.pasandroidsemester2.LoginActivity;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.ActivityMainBinding;
import com.example.pasandroidsemester2.databinding.FragmentMainProfileBinding;
import com.example.pasandroidsemester2.queries.ProfileQuery;
import com.example.pasandroidsemester2.responses.ResponseGetProfile;
import com.example.pasandroidsemester2.responses.Viewer;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainProfileFragment extends Fragment {

    private ActivityMainBinding mainBinding;
    private FragmentMainProfileBinding binding;
    private Preferences pref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Setup data binding/view binding for this fragment
        mainBinding = ActivityMainBinding.inflate(getActivity().getLayoutInflater());
        binding = FragmentMainProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // For reading/writing data from/in SharedPreferences
        pref = new Preferences(getContext());

        // Load profile data to fragment
        ProfileQuery profileQuery = new ProfileQuery();
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseGetProfile> call = apiService.getProfile(pref.getAuthToken(), profileQuery);
        mainBinding.refreshLayout.setRefreshing(true);
        call.enqueue(new Callback<ResponseGetProfile>() {
            @Override
            public void onResponse(Call<ResponseGetProfile> call, Response<ResponseGetProfile> response) {
                
                ErrorResponseChecker errorChecker = new ErrorResponseChecker(response);
                if (errorChecker.isBodyNull()) {
                    int errorCode = errorChecker.getCodeError();
                    String error = String.format(
                            "ERROR: %d: %s",
                            errorCode,
                            "Something went wrong while trying to send request to AniList");
                    Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                    Log.e("PROFILE-ERROR", error);
                    return;
                }

                // Get data from Viewer object
                Viewer viewer = response.body().getData().getViewer();
                String name = viewer.getName();
                int id = viewer.getId();
                String avatar = viewer.getAvatar().getLarge();
                String bannerImage = viewer.getBannerImage();
                String bio = viewer.getAbout();

                // Set widgets' content to the retrieved data
                Picasso.get()
                        .load(avatar)
                        .placeholder(R.color.black)
                        .error(R.drawable.ic_launcher_background)
                        .into(binding.ivAvatar);

                Picasso.get()
                        .load(bannerImage)
                        .placeholder(R.color.black)
                        .error(R.drawable.ic_launcher_background)
                        .fit()
                        .centerCrop()
                        .into(binding.ivBanner);

                binding.tvUsername.setText(name);
                binding.tvBio.setText(bio);
                binding.tvId.setText("ID: " + id);
            }

            @Override
            public void onFailure(Call<ResponseGetProfile> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://anilist.co/settings/"));
            startActivity(intent);
        });

        binding.btnLogout.setOnClickListener(view1 -> {
            pref.setIsLoggedIn(false);
            pref.setAuthToken("");
            startActivity(new Intent(requireContext(), LoginActivity.class));
            Toast.makeText(getActivity(), "Logged out from AniList account", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        });

        return view;
    }


}