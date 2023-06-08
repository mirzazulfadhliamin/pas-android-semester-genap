package com.example.pasandroidsemester2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.example.pasandroidsemester2.ApiClient;
import com.example.pasandroidsemester2.ApiService;
import com.example.pasandroidsemester2.ErrorResponseChecker;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.FragmentLoginAuthBinding;
import com.example.pasandroidsemester2.queries.ProfileQuery;
import com.example.pasandroidsemester2.responses.profile.ResponseGetProfile;
import com.example.pasandroidsemester2.responses.profile.ProfileViewer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAuthFragment extends Fragment {
    private FragmentLoginAuthBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoginAuthBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Perform btn_login's action when the done key is entered
        binding.tfAuth.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.btnLogin.performClick();
                return true;
            }
            return false;
        });

        binding.btnToken.setOnClickListener(v -> {
            Intent browserIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://anilist.co/api/v2/oauth/authorize?client_id=12817&response_type=token"));
            startActivity(browserIntent);
        });

        binding.btnLogin.setOnClickListener(v -> {
            String authToken = binding.tfAuth.getText().toString();
            ProfileQuery query = new ProfileQuery();

            ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
            Call<ResponseGetProfile> call = apiService.getProfile("Bearer " + authToken, query);
            call.enqueue(new Callback<ResponseGetProfile>() {
                @Override
                public void onResponse(Call<ResponseGetProfile> call, Response<ResponseGetProfile> response) {
                    ErrorResponseChecker errorChecker = new ErrorResponseChecker<>(response);

                    if (errorChecker.isBodyNull()) {
                        int errorCode = errorChecker.getCodeError();
                        String error = String.format("ERROR: %d: %s", errorCode, response.message());
                        String reminder = "Please make sure you entered the correct authentication token";
                        Log.e("LOGIN-ERROR", error);
                        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), reminder, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Preferences pref = new Preferences(getContext());
                    pref.setAuthToken(authToken);
                    ProfileViewer profileViewer = response.body().getData().getViewer();
                    String name = profileViewer.getName();
                    int id = profileViewer.getId();
                    String avatar = profileViewer.getAvatar().getLarge();
                    String bannerImage = profileViewer.getBannerImage();
                    Toast.makeText(getContext(), "Identified user: " + name, Toast.LENGTH_SHORT).show();
                    // Create bundle to pass data to confirmation fragment
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putInt("id", id);
                    bundle.putString("avatar", avatar);
                    bundle.putString("banner_image", bannerImage);
                    bundle.putString("auth_token", authToken);

                    LoginConfirmationFragment loginConfirmationFragment = new LoginConfirmationFragment();
                    // Pass bundle to loginConfirmationFragment
                    loginConfirmationFragment.setArguments(bundle);
                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fc_view, loginConfirmationFragment)
                            .commit();
                }

                @Override
                public void onFailure(Call<ResponseGetProfile> call, Throwable t) {
                    Toast.makeText(getContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            });
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}