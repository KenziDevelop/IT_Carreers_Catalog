package com.pab.it_carreers_catalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.pab.it_carreers_catalog.databinding.ActivityBackEndBinding

class BackEndActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBackEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBackEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Daftar fragment untuk ViewPager
        val fragments = listOf(
            BackEndPageFragment.newInstance("overview"),
            BackEndPageFragment.newInstance("skills"),
            BackEndPageFragment.newInstance("careers")
        )

        // Adapter ViewPager
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }

        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = true // bisa swipe

        // Hubungkan TabLayout dengan ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Overview"
                1 -> "Skills"
                2 -> "Careers"
                else -> ""
            }
        }.attach()

        // Tombol back
        binding.btnBack.setOnClickListener { finish() }
    }
}