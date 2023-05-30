package com.example.pasandroidsemester2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pasandroidsemester2.databinding.ActivityLoginBinding;
import com.example.pasandroidsemester2.fragment.LoginAuthFragment;
import com.example.pasandroidsemester2.fragment.LoginConfirmationFragment;
import com.example.pasandroidsemester2.queries.ProfileQuery;
import com.example.pasandroidsemester2.responses.ResponseGetProfile;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        LoginAuthFragment loginAuthFragment = new LoginAuthFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fc_view, loginAuthFragment, LoginAuthFragment.class.getSimpleName())
                .commit();

//        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String authToken = binding.tfAuth.getText().toString();
//                ProfileQuery query = new ProfileQuery();
//
//                ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
//                Call<ResponseGetProfile> call = apiService.getProfile("Bearer " + authToken, query);
//                call.enqueue(new Callback<ResponseGetProfile>() {
//                    @Override
//                    public void onResponse(Call<ResponseGetProfile> call, Response<ResponseGetProfile> response) {
//
//                        if (response.code() > 399) {
//                            String error = String.format("ERROR %d: Please make sure you entered the correct token", response.code());
//                            Log.e("LOGIN-ERROR", error);
//                            Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                        String name = response.body().getData().getViewer().getName();
//                        Toast.makeText(LoginActivity.this, name, Toast.LENGTH_SHORT).show();
//
//                        String userName = response.body().getData().getViewer().getName();
//                        int id = response.body().getData().getViewer().getId();
//                        String userAvatar = response.body().getData().getViewer().getAvatar().getLarge();
//                        String userBannerImage = response.body().getData().getViewer().getBannerImage();
//
//                        binding.tvName.setText(userName);
//                        binding.tvId.setText(Integer.toString(id));
//                        Picasso.get()
//                                .load(userAvatar)
//                                .placeholder(R.drawable.baseline_home_24)
//                                .error(R.drawable.baseline_home_24)
//                                .into(binding.ivAvatar);
//                        Picasso.get()
//                                .load(userBannerImage)
//                                .placeholder(R.drawable.baseline_home_24)
//                                .error(R.drawable.baseline_home_24)
//                                .fit()
//                                .centerCrop()
//                                .into(binding.ivBanner);
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseGetProfile> call, Throwable t) {
//                        Toast.makeText(LoginActivity.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                        Log.e("LOGIN-ERROR", t.getCause().getMessage());
//                    }
//                });
//            }
//        });
    }
}