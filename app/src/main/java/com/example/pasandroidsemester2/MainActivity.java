package com.example.pasandroidsemester2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pasandroidsemester2.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.example.pasandroidsemester2.fragment.MainHomeFragment;
import com.example.pasandroidsemester2.fragment.MainProfileFragment;
import com.example.pasandroidsemester2.fragment.MainSearchFragment;



public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;
    BroadcastReceiver broadcastReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

/*        binding.rv_anime.setLayoutManager(new GridLayoutManager(this,2));*/

        broadcastReceiver = new InternetReceiver();
        InternetStatus();
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //fragment
        MainSearchFragment mainSearchFragment = new MainSearchFragment();
        MainProfileFragment mainProfileFragment = new MainProfileFragment();
        MainHomeFragment mainHomeFragment = new MainHomeFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_frame_layout, mainHomeFragment, MainHomeFragment.class.getSimpleName())
                .commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                // Melakukan transaksi fragment sesuai item yang dipilih
                if (item.getItemId() == R.id.homefragment) {

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_frame_layout, mainHomeFragment)
                            .commit();
                } else if (item.getItemId() == R.id.searchfragment) {

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_frame_layout, mainSearchFragment)
                            .commit();
                } else if (item.getItemId() == R.id.profilefragment) {

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_frame_layout, mainProfileFragment)
                            .commit();
                }
                return true;
            }
        });



    }

    public void getAnimeList(){
        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);

    }
    public void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void InternetStatus(){
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }


}

