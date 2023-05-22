package com.example.pasandroidsemester2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.pasandroidsemester2.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

BottomNavigationView bottomNavigationView;

HomeFragment homeFragment = new HomeFragment();
SearchFragment searchFragment = new SearchFragment();
ProfileFragment profileFragment = new ProfileFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.containerFramelayout, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.homefragment:
                            getSupportFragmentManager().beginTransaction().replace(R.id.containerFramelayout, homeFragment).commit();
                            return true;

                        case R.id.searchfragment:
                            getSupportFragmentManager().beginTransaction().replace(R.id.containerFramelayout,searchFragment ).commit();
                            return true;
                }

                return false;
            }
        });


    }

    public void getAnimeList(){
        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);

    }
}