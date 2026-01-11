package com.pab.it_carreers_catalog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.pab.it_carreers_catalog.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = OnboardingAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabIndicator, binding.viewPager) { _, _ -> }.attach()
    }

    // ✅ TAMBAHKAN INI
    fun getViewPager(): ViewPager2 {
        return binding.viewPager
    }

    fun finishOnboarding() {
        val prefs = getSharedPreferences("app_pref", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("onboarding_completed", true).apply()

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
