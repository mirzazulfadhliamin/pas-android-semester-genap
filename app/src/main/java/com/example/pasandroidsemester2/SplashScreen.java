package com.example.pasandroidsemester2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    private Preferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        * TODO: GANTI SEMUA STRING DENGAN VALUE DARI strings.xml
        */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);// fullscren

        if (getSupportActionBar() != null) { //hilangin actionbar
            getSupportActionBar().hide();
        }

        pref = new Preferences(this);

        if (pref.getIsLoggedIn()) {
            new Handler().postDelayed(() -> {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }, 2000);
        } else {
            new Handler().postDelayed(() -> {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }, 2000);
        }


    }
}

