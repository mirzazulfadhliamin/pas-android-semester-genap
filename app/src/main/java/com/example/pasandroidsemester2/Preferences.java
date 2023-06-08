package com.example.pasandroidsemester2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private final String prefName = "auth_secret";
    private final String isLoggedIn = "is_logged_in";
    private final String authToken = "auth_token";

    public Preferences(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        pref = context.getSharedPreferences(prefName, context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setIsLoggedIn(boolean value) {
        editor.putBoolean(isLoggedIn, value);
        editor.commit();
    }

    public boolean getIsLoggedIn() {
        return pref.getBoolean(isLoggedIn, false);
    }

    public void setAuthToken(String token) {
        editor.putString(authToken, token);
        editor.commit();
    }

    public String getAuthToken() {
        return pref.getString(authToken, "");
    }

    public boolean isFirstRun() {
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        if (isFirstRun) {
            sharedPreferences.edit().putBoolean("isFirstRun", false).apply();
        }
        return isFirstRun;
    }
}
