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
import com.pab.it_carreers_catalog.databinding.FragmentDataScientistPageBinding
import android.content.res.ColorStateList

class DataScientistPageFragment : Fragment() {

    private var _binding: FragmentDataScientistPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): DataScientistPageFragment {
            return DataScientistPageFragment().apply {
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
        _binding = FragmentDataScientistPageBinding.inflate(inflater, container, false)
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
                "Menggabungkan statistik, machine learning, dan programming untuk mengekstrak insight dari data besar",
                "Membangun model prediktif, algoritma AI, dan sistem rekomendasi untuk bisnis",
                "Bekerja lintas tim untuk menerjemahkan masalah bisnis menjadi solusi data-driven",
                "Mengkomunikasikan hasil analisis melalui visualisasi dan cerita data (data storytelling)"
            )
        )
        addChips(listOf("Python", "R", "TensorFlow", "PyTorch", "Scikit-learn", "Pandas", "SQL", "Big Data", "Machine Learning"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Machine Learning & Deep Learning",
                "Statistical Modeling & Probability",
                "Programming (Python/R)",
                "Data Wrangling & ETL",
                "Big Data Tools (Spark, Hadoop)",
                "Model Deployment & MLOps",
                "Data Storytelling & Communication"
            )
        )
        addChips(listOf("Python", "TensorFlow", "PyTorch", "Scikit-learn", "Pandas & NumPy", "SQL", "Spark", "NLP", "Computer Vision", "MLOps"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Junior Data Scientist",
                "→ Data Scientist",
                "→ Machine Learning Engineer",
                "→ AI Research Scientist",
                "→ MLOps Engineer",
                "→ Senior Data Scientist / Lead Data Scientist"
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
                    setTextColor(Color.parseColor("#0EA5E9"))  // Biru muda untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#DBEAFE"))  // Biru muda background
                setTextColor(Color.parseColor("#0EA5E9"))  // Biru muda teks
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