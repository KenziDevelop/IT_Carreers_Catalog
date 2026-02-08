//package com.pab.it_carreers_catalog
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.viewpager2.widget.ViewPager2
//import com.google.android.material.tabs.TabLayoutMediator
//import com.pab.it_carreers_catalog.databinding.ActivityOnboardingBinding
//
//class OnboardingAdapter : AppCompatActivity() {
//
//    private lateinit var binding: ActivityOnboardingBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityOnboardingBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Adapter untuk 4 screen (intro + 3 screen)
//        val adapter = OnboardingAdapter(this)  // pastikan nama class adapter lu OnboardingAdapter (bukan nboardingAdapter, typo tadi)
//        binding.viewPager.adapter = adapter
//
//        // TabLayout (dots indicator)
//        TabLayoutMediator(binding.tabIndicator, binding.viewPager) { tab, position ->
//            // Optional: kalau mau kasih text di tab
//            // tab.text = when (position) { 0 -> "Intro" else -> "" }
//        }.attach()
//
//        // Contoh: kalau lu mau auto next atau kontrol dari fragment, bisa pakai ini
//        // binding.viewPager.isUserInputEnabled = true // swipe diizinkan
//    }
//
//    // Fungsi untuk akses ViewPager dari fragment kalau perlu
//    fun getViewPager(): ViewPager2 = binding.viewPager
//
//    // Fungsi selesai onboarding (dipanggil dari screen terakhir atau tombol Skip)
//    fun finishOnboarding() {
//        val prefs = getSharedPreferences("app_pref", Context.MODE_PRIVATE)
//        prefs.edit().putBoolean("onboarding_completed", true).apply()
//
//        startActivity(Intent(this, LoginActivity::class.java))
//        finish()
//    }
//}