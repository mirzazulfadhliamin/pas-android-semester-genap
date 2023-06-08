package com.example.pasandroidsemester2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private Preferences pref;
    private boolean isFirstRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); // fullscren

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide(); // hilangkan actionbar
        }

        pref = new Preferences(this);
        isFirstRun = pref.getFirstRun(this);

        new Handler().postDelayed(() -> {
            if (isFirstRun) {
                startActivity(new Intent(SplashScreen.this, OnboardingActivity.class));
            } else if (pref.getIsLoggedIn()) {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            } else {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
            }
            finish();
        }, 2000);
    }
}


