package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityOnboardingScreen1Binding

class OnboardingScreen1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingScreen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Skip → langsung ke login
        binding.tvSkip.setOnClickListener {
            finishOnboarding()
        }

        // Next → ke screen 2
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, OnboardingScreen2Activity::class.java))
            finish()
        }

        // Opsional: auto next setelah 5 detik
        // Handler(Looper.getMainLooper()).postDelayed({
        //     startActivity(Intent(this, OnboardingScreen2Activity::class.java))
        //     finish()
        // }, 5000)
    }

    private fun finishOnboarding() {
        val prefs = getSharedPreferences("app_pref", MODE_PRIVATE)
        prefs.edit().putBoolean("onboarding_completed", true).apply()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}