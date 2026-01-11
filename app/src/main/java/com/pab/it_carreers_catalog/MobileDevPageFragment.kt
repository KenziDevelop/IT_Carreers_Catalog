package com.pab.it_carreers_catalog

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.pab.it_carreers_catalog.databinding.FragmentMobileDevPageBinding
import android.content.res.ColorStateList

class MobileDevPageFragment : Fragment() {

    private var _binding: FragmentMobileDevPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): MobileDevPageFragment {
            return MobileDevPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PAGE_TYPE, pageType)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMobileDevPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pageType = arguments?.getString(ARG_PAGE_TYPE) ?: "overview"

        when (pageType) {
            "overview" -> setupOverview()
            "skills" -> setupSkills()
            "careers" -> setupCareers()
        }
    }

    private fun setupOverview() {
        binding.tvSectionTitle.text = "About This Career"
        addBulletPoints(
            listOf(
                "Membangun aplikasi mobile untuk platform Android dan iOS, baik native maupun cross-platform",
                "Fokus pada performa tinggi, UI/UX yang intuitif, dan integrasi dengan backend/API",
                "Bekerja dengan desainer untuk implementasi desain pixel-perfect dan responsif di berbagai ukuran layar",
                "Mengelola deployment ke Google Play/App Store, update, dan maintenance aplikasi"
            )
        )
        addChips(listOf("Kotlin", "Swift", "Flutter", "React Native", "Dart", "Firebase", "Jetpack Compose", "SwiftUI"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Android Development (Kotlin/Jetpack)",
                "iOS Development (Swift/SwiftUI)",
                "Cross-Platform (Flutter/React Native)",
                "Mobile UI/UX & Responsive Design",
                "API Integration & Networking",
                "App Performance & Security",
                "App Store Deployment"
            )
        )
        addChips(listOf("Kotlin", "Jetpack Compose", "Swift", "SwiftUI", "Flutter", "React Native", "Dart", "Firebase", "REST API"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Android Developer",
                "→ iOS Developer",
                "→ Flutter Developer",
                "→ React Native Developer",
                "→ Mobile Engineer",
                "→ Cross-Platform Mobile Developer",
                "→ Senior Mobile Developer"
            ),
            isLink = true
        )
    }

    private fun addBulletPoints(items: List<String>, isLink: Boolean = false) {
        val container = binding.containerContent
        container.removeAllViews()

        items.forEach { text ->
            val tv = TextView(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 12.dpToPx() }
                setText(text)
                textSize = 16f
                setTextColor(ContextCompat.getColor(context, R.color.text_primary))
                if (isLink) {
                    setTextColor(Color.parseColor("#EC4899"))  // Pink untuk link
                    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
                }
            }
            container.addView(tv)
        }
    }

    private fun addChips(items: List<String>) {
        val chipGroup = ChipGroup(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = 16.dpToPx() }
            isSingleSelection = false
        }

        items.forEach { label ->
            val chip = Chip(requireContext()).apply {
                text = label
                isCheckable = false
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#FCE7F3"))  // Pink muda background
                setTextColor(Color.parseColor("#EC4899"))  // Pink teks
            }
            chipGroup.addView(chip)
        }
        binding.containerContent.addView(chipGroup)
    }

    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}