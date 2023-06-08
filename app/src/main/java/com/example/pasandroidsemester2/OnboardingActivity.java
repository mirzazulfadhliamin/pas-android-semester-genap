package com.example.pasandroidsemester2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pasandroidsemester2.MainActivity;
import com.example.pasandroidsemester2.fragment.MainHomeFragment;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;
import java.util.ArrayList;
public class OnboardingActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        // Get saved data from disk
        preferences = new Preferences(this);

        fragmentManager = getSupportFragmentManager();
        PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment);
        fragmentTransaction.commit();

        paperOnboardingFragment.setOnRightOutListener(() -> {
            if (preferences.getIsLoggedIn()) {
                Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(OnboardingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }



    private ArrayList<PaperOnboardingPage> getDataforOnboarding() {
        String[] onboardingTitle = getResources().getStringArray(R.array.onboarding_title);
        String[] onboardingDescription = getResources().getStringArray(R.array.onboarding_description);
        PaperOnboardingPage source1 = new PaperOnboardingPage(onboardingTitle[0], onboardingDescription[0], Color.parseColor("#ffffff"),R.drawable.home, R.drawable.home);
        PaperOnboardingPage source2 = new PaperOnboardingPage(onboardingTitle[1], onboardingDescription[1], Color.parseColor("#ffffff"),R.drawable.home, R.drawable.home);
        PaperOnboardingPage source3 = new PaperOnboardingPage(onboardingTitle[2], onboardingDescription[2], Color.parseColor("#ffffff"),R.drawable.home, R.drawable.home);
        PaperOnboardingPage source4 = new PaperOnboardingPage(onboardingTitle[3], onboardingDescription[3], Color.parseColor("#ffffff"),R.drawable.home, R.drawable.home);
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();

        elements.add(source1);
        elements.add(source2);
        elements.add(source3);
        elements.add(source4);

        return elements;




    }
}