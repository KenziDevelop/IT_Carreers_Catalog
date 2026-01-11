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
import com.pab.it_carreers_catalog.databinding.FragmentDataAnalystPageBinding
import android.content.res.ColorStateList

class DataAnalystPageFragment : Fragment() {

    private var _binding: FragmentDataAnalystPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): DataAnalystPageFragment {
            return DataAnalystPageFragment().apply {
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
        _binding = FragmentDataAnalystPageBinding.inflate(inflater, container, false)
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
                "Mengumpulkan, membersihkan, dan menganalisis data untuk menghasilkan insight bisnis",
                "Membuat laporan, dashboard, dan visualisasi data yang mudah dipahami stakeholder",
                "Bekerja sama dengan tim bisnis untuk mendukung pengambilan keputusan berbasis data",
                "Mengidentifikasi tren, pola, dan peluang dari data besar (big data)"
            )
        )
        addChips(listOf("Excel", "SQL", "Tableau", "Power BI", "Google Data Studio", "Python", "R", "Statistics"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "SQL & Database Querying",
                "Data Cleaning & Wrangling",
                "Statistical Analysis & Hypothesis Testing",
                "Data Visualization & Dashboarding",
                "Excel Advanced & BI Tools",
                "Basic Python/R untuk automation"
            )
        )
        addChips(listOf("SQL", "Microsoft Excel", "Tableau", "Power BI", "Google Sheets", "Python (Pandas)", "R", "Statistics", "A/B Testing"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Junior Data Analyst",
                "→ Data Analyst",
                "→ Business Intelligence Analyst",
                "→ Reporting Analyst",
                "→ Marketing Analyst",
                "→ Data Visualization Specialist"
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
                    setTextColor(Color.parseColor("#FBBF24"))  // Kuning untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#FEF3C7"))  // Kuning muda background
                setTextColor(Color.parseColor("#FBBF24"))  // Kuning teks
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