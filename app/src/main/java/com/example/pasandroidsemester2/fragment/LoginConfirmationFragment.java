package com.example.pasandroidsemester2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pasandroidsemester2.MainActivity;
import com.example.pasandroidsemester2.Preferences;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.FragmentLoginConfirmationBinding;
import com.squareup.picasso.Picasso;

public class LoginConfirmationFragment extends Fragment {
    private FragmentLoginConfirmationBinding binding;
    private Preferences pref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginConfirmationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Set SharedPreferences
        pref = new Preferences(getContext());

        // Get passed data
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        int id = bundle.getInt("id", 0);
        String avatar = bundle.getString("avatar");
        String bannerImage = bundle.getString("banner_image");
        String authToken = bundle.getString("auth_token");

        Picasso
                .get()
                .load(avatar)
                .placeholder(R.drawable.baseline_home_24)
                .error(R.drawable.baseline_home_24)
                .into(binding.ivAvatar);

        Picasso
                .get()
                .load(bannerImage)
                .fit()
                .centerCrop()
                .into(binding.ivBanner);

        binding.tvName.setText(name);
        binding.tvId.setText("ID: " + Integer.toString(id));

        binding.btnLogin.setOnClickListener(v -> {
            pref.setAuthToken(authToken);
            pref.setIsLoggedIn(true);
            Toast.makeText(getContext(), Integer.toString(id), Toast.LENGTH_SHORT).show();
            pref.setUserId(id);
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        binding.btnDeny.setOnClickListener(v -> {
            LoginAuthFragment loginAuthFragment = new LoginAuthFragment();
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fc_view, loginAuthFragment)
                    .commit();
        });

        return view;
    }
}