package com.example.pasandroidsemester2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pasandroidsemester2.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import fragment.HomeFragment;
import fragment.ProfileFragment;
import fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final SwipeRefreshLayout refreshLayout = binding.refreshLayout;

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        SearchFragment searchFragment = new SearchFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        HomeFragment homeFragment = new HomeFragment();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFramelayout, homeFragment, HomeFragment.class.getSimpleName())
                .commit();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //ToDo
                //tambahin buat refresh rek biar kalo di swipe ke atas animenya ganti
            }
        });


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homefragment){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.containerFramelayout, homeFragment)
                            .commit();
                }else if(item.getItemId() == R.id.searchfragment){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.containerFramelayout, searchFragment)
                            .commit();
                } else if (item.getItemId() == R.id.profilefragment) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.containerFramelayout, profileFragment)
                            .commit();

                }
                return false;
            }
        });


    }

    public void getAnimeList(){
        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);

    }
}