package com.pab.it_carreers_catalog

import android.content.Intent // Tambahkan ini
import android.content.res.ColorStateList // Tambahkan ini
import android.graphics.Color // Tambahkan ini
import android.os.Bundle
import android.widget.Toast // Tambahkan ini
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Rating bar tint kuning
        binding.ratingBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#FBBF24"))
        binding.ratingBar.secondaryProgressTintList = ColorStateList.valueOf(Color.parseColor("#FBBF24"))
        binding.ratingBar.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FBBF24"))

        // Social icons klik (placeholder)
        binding.ivGithub.setOnClickListener {
            Toast.makeText(this, "Twitter/X (coming soon)", Toast.LENGTH_SHORT).show()
        }

        binding.ivTwitter.setOnClickListener {
            Toast.makeText(this, "Instagram (coming soon)", Toast.LENGTH_SHORT).show()
        }

        binding.ivLinkedin.setOnClickListener {
            Toast.makeText(this, "LinkedIn (coming soon)", Toast.LENGTH_SHORT).show()
        }

        // Sign Out (opsional, kalau user login)
        binding.btnSignout.setOnClickListener {
            // Clear session
            getSharedPreferences("user_pref", MODE_PRIVATE).edit().clear().apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()  // tutup semua activity
        }

        // Bottom Nav
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.menu_about -> true  // sudah di about
                R.id.menu_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
        binding.bottomNav.selectedItemId = R.id.menu_about  // highlight About
    }
}
