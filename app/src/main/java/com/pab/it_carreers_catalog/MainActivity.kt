package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("app_pref", MODE_PRIVATE)

        val onboardingCompleted = sharedPref.getBoolean("onboarding_completed", false)
        val isLoggedIn = sharedPref.getBoolean("is_logged_in", false)

        // Log untuk debug
        Log.d("MainDebug", "onboarding_completed: $onboardingCompleted")
        Log.d("MainDebug", "is_logged_in: $isLoggedIn")

        if (!onboardingCompleted) {
            Log.d("MainDebug", "Masuk OnboardingIntroActivity")
            startActivity(Intent(this, OnboardingIntroActivity::class.java))
        } else {
            if (isLoggedIn) {
                Log.d("MainDebug", "Masuk DashboardActivity (sudah login)")
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Log.d("MainDebug", "Masuk LoginActivity")
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

        finish()
    }
}