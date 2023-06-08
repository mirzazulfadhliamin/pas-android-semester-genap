package com.example.pasandroidsemester2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.ActivityDetailBinding;
import com.example.pasandroidsemester2.queries.DetailQuery;
import com.example.pasandroidsemester2.responses.detail.Data;
import com.example.pasandroidsemester2.responses.detail.DetailMedia;
import com.example.pasandroidsemester2.responses.detail.ResponseGetDetail;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    Preferences pref;
    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        pref = new Preferences(this);

        Intent intent = getIntent();
        int mediaId = intent.getIntExtra("media_id", 1);
        setContent(mediaId);
    }

    private void setContent(int id) {
        DetailQuery detailQuery = new DetailQuery(id);
        String authToken = pref.getAuthToken();

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseGetDetail> call = apiService.getDetail("Bearer "+authToken, detailQuery);
        call.enqueue(new Callback<ResponseGetDetail>() {
            @Override
            public void onResponse(Call<ResponseGetDetail> call, Response<ResponseGetDetail> response) {
                ErrorResponseChecker errorChecker = new ErrorResponseChecker(response);
                if (errorChecker.isBodyNull()) {
                    int errorCode = errorChecker.getCodeError();
                    String error = String.format(
                            "ERROR: %d: %s",
                            errorCode,
                            "Something went wrong while trying to send request to AniList");
                    Toast.makeText(DetailActivity.this, error, Toast.LENGTH_SHORT).show();
                    Log.e("PROFILE-ERROR", error);
                    return;
                }

                DetailMedia detailMedia = response.body().getData().getMedia();
                String title = detailMedia.getTitle().getRomaji();
                String desc = detailMedia.getDescription();
                String posterUrl = detailMedia.getCoverImage().getExtraLarge();
                String bannerUrl = detailMedia.getBannerImage();

                binding.ivTitle.setText(title);
                binding.ivDescription.setText(desc);

                Picasso.get()
                        .load(bannerUrl)
                        .fit()
                        .centerCrop()
                        .placeholder(R.color.backgorund_nv)
                        .error(R.color.backgorund_nv)
                        .into(binding.ivBanner);

                Picasso.get()
                        .load(posterUrl)
                        .placeholder(R.color.backgorund_nv)
                        .error(R.color.backgorund_nv)
                        .into(binding.ivPoster);

            }

            @Override
            public void onFailure(Call<ResponseGetDetail> call, Throwable t) {

            }
        });
    }
}