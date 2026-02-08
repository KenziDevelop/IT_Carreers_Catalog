package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityOnboardingIntroBinding

class OnboardingIntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Auto next setelah 5 detik (opsional, kalau ga mau hapus blok ini)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, OnboardingScreen1Activity::class.java))
            finish()
        }, 5000)

        // Kalau mau manual Next button (tambahkan kalau ada di XML lu)
        // binding.btnNext.setOnClickListener {
        //     startActivity(Intent(this, OnboardingScreen1Activity::class.java))
        //     finish()
        // }
    }
}