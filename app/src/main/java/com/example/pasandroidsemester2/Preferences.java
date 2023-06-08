package com.example.pasandroidsemester2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Preferences {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private final String prefName = "auth_secret";
    private final String isLoggedIn = "is_logged_in";
    private final String authToken = "auth_token";
    private final String firstRun = "first_run";

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

    public boolean getFirstRun(Context context) {
        boolean isFirstRun = pref.getBoolean(firstRun, true);
        return isFirstRun;
    }

    public void setFalseFirstRun() {
        editor.putBoolean(firstRun, false);
        editor.commit();
    }
}
