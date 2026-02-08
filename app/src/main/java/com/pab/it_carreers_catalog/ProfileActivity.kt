package com.pab.it_carreers_catalog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pab.it_carreers_catalog.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data user dari SharedPreferences
        val sharedPref = getSharedPreferences("app_pref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "Ade Suryadi") ?: "Ade Suryadi"
        val email = sharedPref.getString("email", "Ade@gmail.com") ?: "Ade@gmail.com"

        binding.tvName.text = username
        binding.tvEmail.text = email

        // Status Aktif (hardcode dulu, nanti bisa dinamis dari server/DB)
        binding.statusBadge.text = "Status : Aktif"  // pastikan ID di XML adalah statusBadge

        // Achievement (hardcode dulu, nanti ambil dari database atau SharedPreferences)
        // binding.tvSelesai.text = "5"
        // binding.tvTersimpan.text = "12"
        // binding.tvStreak.text = "7"

        // Menu klik (contoh untuk Edit Profile)
        binding.editProfileLayout.setOnClickListener {
            Toast.makeText(this, "Edit Profile (coming soon)", Toast.LENGTH_SHORT).show()
            // Nanti buka EditProfileActivity di sini
        }

        // Tambah listener untuk menu lain kalau ada
        // misal: binding.notificationLayout.setOnClickListener { ... }

        // Sign Out
        binding.btnSignout.setOnClickListener {
            // Hapus semua data user
            sharedPref.edit().clear().apply()

            Toast.makeText(this, "Anda telah keluar", Toast.LENGTH_SHORT).show()

            // Kembali ke Login dan tutup semua activity sebelumnya
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()  // tutup semua activity di stack
        }

        // Bottom Navigation
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.menu_about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                    finish()
                    true
                }
                R.id.menu_profile -> true  // sudah di profile
                else -> false
            }
        }

        // Highlight item Profile
        binding.bottomNav.selectedItemId = R.id.menu_profile
    }
}