package com.pab.it_carreers_catalog

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pab.it_carreers_catalog.OnboardingCommonFragment // pastikan import ini ada
import com.pab.it_carreers_catalog.OnboardingIntroFragment

class OnboardingAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingIntroFragment()
            1 -> OnboardingCommonFragment.newInstance(
                R.drawable.onboarding_screen1,
                R.drawable.ic_calendar_blue,
                "#6366F1",
                "Jelajahi Karier di Bidang IT",
                "Temukan 10+ jalur karier menarik di bidang teknologi dan temukan yang paling cocok untuk Anda."
            )
            2 -> OnboardingCommonFragment.newInstance(
                R.drawable.onboarding_screen2,
                R.drawable.ic_code_pink,
                "#EC4899",
                "Learn Skill dan Tools",
                "Dapatkan wawasan mendalam tentang keterampilan teknis dan alat-alat untuk setiap karier."
            )
            3 -> OnboardingCommonFragment.newInstance(
                R.drawable.onboarding_screen3,
                R.drawable.ic_growth_orange,
                "#FB923C",
                "Lacak Kemajuan Anda",
                "Simpan favorit, lacak kemajuan belajar, dan raih tujuan karier Anda.",
                isLast = true
            )
            else -> OnboardingIntroFragment()
        }
    }
}