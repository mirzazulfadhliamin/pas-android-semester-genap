package com.example.pasandroidsemester2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pasandroidsemester2.LoginActivity;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.ActivityMainBinding;
import com.example.pasandroidsemester2.databinding.FragmentMainProfileBinding;


public class MainProfileFragment extends Fragment {

    private FragmentMainProfileBinding binding;
    private Preferences pref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Setup data binding/view binding for this fragment
        binding = FragmentMainProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Change data in SharedPreferences
        pref = new Preferences(getContext());


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