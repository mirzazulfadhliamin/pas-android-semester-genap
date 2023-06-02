package com.example.pasandroidsemester2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.FragmentMainHomeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainHomeFragment extends Fragment {

    private FragmentMainHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        HomeTabAdapter adapter = new HomeTabAdapter(this);
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setSaveEnabled(false);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = binding.TabLayout;
        new TabLayoutMediator(tabLayout,
                viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: {
                            tab.setText("HOME");
                            break;
                        }
                        case 1: {
                            tab.setText("ANIME");
                            break;
                        }
                        default: break;
                    }
                }).attach();

        return view;
    }

    class HomeTabAdapter extends FragmentStateAdapter {

        public HomeTabAdapter(Fragment fragment) {
            super(fragment);
        }

//        @NonNull
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    return new HomePopularFragment();
//                case 1:
//                    return new HomeAnimeFragment();
//                default:
//                    return null;
//            }
//        }

        // Udh gk perlu sama sekali
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "HOME";
//                case 1:
//                    return "Anime";
//
//                default:
//                    return null;
//            }
//        }

//        @Override
//        public int getCount() {
//            return 2;
//        }

        // Pengganti getItem()
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new HomePopularFragment();
                case 1:
                    return new HomeAnimeFragment();
                default:
                    return null;
            }
        }

        // Pengganti getCount()
        @Override
        public int getItemCount() {
            return 2;
        }
    }
}
