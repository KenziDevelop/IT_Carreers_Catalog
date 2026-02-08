package com.pab.it_carreers_catalog

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pab.it_carreers_catalog.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil username dari SharedPreferences (dikirim dari login/register)
        val sharedPref = getSharedPreferences("app_pref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User") ?: "User"
        binding.tvGreeting.text = "Hi, $username!"

        // Setup RecyclerView Vertical
        val careerList = getCareerList()
        val adapter = CareerAdapter(careerList)
        binding.rvCareerPaths.adapter = adapter
        binding.rvCareerPaths.layoutManager = LinearLayoutManager(this)

        // Bottom Navigation
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> true
                R.id.menu_about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                    false
                }
                R.id.menu_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    false
                }
                else -> false
            }
        }

        // Search bar (opsional)
        binding.searchEditText.setOnClickListener {
            Toast.makeText(this, "Cari karier (coming soon)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCareerList(): List<CareerItem> {
        return listOf(
            CareerItem(
                "Front-End Developer",
                R.drawable.front1,
                R.drawable.gradient_front_end,
                "Membangun antarmuka website.",
                FrontEndActivity::class.java
            ),
            CareerItem(
                "Back-End Developer",
                R.drawable.backend1,
                R.drawable.gradient_back_end,
                "Mengelola server, database, dan logika.",
                BackEndActivity::class.java
            ),
            CareerItem(
                "Mobile Developer",
                R.drawable.mobile1,
                R.drawable.gradient_mobile,
                "Membuat aplikasi Android/iOS.",
                MobileDevActivity::class.java
            ),
            CareerItem(
                "Game Developer",
                R.drawable.game1,
                R.drawable.gradient_game,
                "Merancang dunia game, mekanik.",
                GameDevActivity::class.java
            ),
            CareerItem(
                "Data Analyst",
                R.drawable.data_analyst1,
                R.drawable.gradient_data_analyst,
                "Mengolah data besar yang berharga.",
                DataAnalystActivity::class.java
            ),
            CareerItem(
                "Data Scientist",
                R.drawable.data_scienties1,
                R.drawable.gradient_data_scientist,
                "Membangun model machine learning.",
                DataScientistActivity::class.java
            ),
            CareerItem(
                "UI/UX Designer",
                R.drawable.ui1,
                R.drawable.gradient_uiux,
                "Merancang pengalaman pengguna.",
                UiUxDesignerActivity::class.java
            ),
            CareerItem(
                "Cyber Security",
                R.drawable.cyber1,
                R.drawable.gradient_cyber,
                "Melindungi sistem dan data dari ancaman.",
                CyberSecurityActivity::class.java
            ),
            CareerItem(
                "Network Engineer",
                R.drawable.network1,
                R.drawable.gradient_network,
                "Merancang, mengelola infrastruktur.",
                NetworkEngineerActivity::class.java
            ),
            CareerItem(
                "Cloud Engineer",
                R.drawable.cloud1,
                R.drawable.gradient_cloud,
                "mengelola infrastruktur cloud.",
                CloudEngineerActivity::class.java
            )
        )
    }
}