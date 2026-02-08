package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityOnboardingScreen2Binding

class OnboardingScreen2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSkip.setOnClickListener {
            finishOnboarding()
        }

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, OnboardingScreen3Activity::class.java))
            finish()
        }
    }

    private fun finishOnboarding() {
        val prefs = getSharedPreferences("app_pref", MODE_PRIVATE)
        prefs.edit().putBoolean("onboarding_completed", true).apply()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}