package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityOnboardingScreen3Binding
import android.util.Log

class OnboardingScreen3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingScreen3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ganti teks tombol jadi "Get Started" karena ini terakhir
        binding.btnNext.text = "Get Started >"

        binding.tvSkip.setOnClickListener {
            finishOnboarding()
        }

        binding.btnNext.setOnClickListener {
            finishOnboarding()
        }
    }

    private fun finishOnboarding() {
        val prefs = getSharedPreferences("app_pref", MODE_PRIVATE)
        prefs.edit().putBoolean("onboarding_completed", true).apply()

        val isLoggedIn = prefs.getBoolean("is_logged_in", false)

        Log.d("OnboardingDebug", "onboarding_completed diset true")
        Log.d("OnboardingDebug", "isLoggedIn saat ini: $isLoggedIn")

        if (isLoggedIn) {
            Log.d("OnboardingDebug", "Masuk Dashboard dari onboarding")
            startActivity(Intent(this, DashboardActivity::class.java))
        } else {
            Log.d("OnboardingDebug", "Masuk Login dari onboarding")
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}