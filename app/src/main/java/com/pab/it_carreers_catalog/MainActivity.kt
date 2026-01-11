package com.pab.it_carreers_catalog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The 'Context' class now resolves correctly because of the import
        val sharedPref = getSharedPreferences("app_pref", Context.MODE_PRIVATE)
        val onboardingCompleted = sharedPref.getBoolean("onboarding_completed", false)

        if (onboardingCompleted) {
            // The 'Intent' class also needs to be imported
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, OnboardingActivity::class.java))
        }
        finish()
    }
}
