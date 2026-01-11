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
import com.pab.it_carreers_catalog.databinding.FragmentBackEndPageBinding
import android.content.res.ColorStateList

class BackEndPageFragment : Fragment() {

    private var _binding: FragmentBackEndPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): BackEndPageFragment {
            return BackEndPageFragment().apply {
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
        _binding = FragmentBackEndPageBinding.inflate(inflater, container, false)
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
                "Membangun logika bisnis, API, database, dan server-side application yang menjadi 'otak' di belakang aplikasi",
                "Mengolah data, autentikasi, keamanan, dan skalabilitas sistem agar aplikasi berjalan lancar untuk ribuan pengguna",
                "Bekerja dengan front-end developer dan database admin untuk integrasi penuh antara client dan server",
                "Fokus pada performa, keamanan, dan efisiensi (clean code, microservices, cloud deployment)"
            )
        )
        addChips(listOf("Node.js", "Express", "Spring Boot", "Django", "Laravel", "PostgreSQL", "MongoDB", "Docker", "AWS"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Server-Side Programming (Java/Node.js/Python/PHP)",
                "RESTful API & GraphQL",
                "Database Management (SQL/NoSQL)",
                "Authentication & Authorization (JWT/OAuth)",
                "Microservices & Cloud Architecture",
                "CI/CD & DevOps Basics",
                "Performance & Security Best Practices"
            )
        )
        addChips(listOf("Node.js", "Spring Boot", "Django", "PostgreSQL", "MongoDB", "Docker", "Kubernetes", "AWS/GCP"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Junior Back-End Developer",
                "→ Back-End Developer",
                "→ API Developer",
                "→ Full-Stack Developer",
                "→ Backend Engineer",
                "→ DevOps Engineer (dengan tambahan infra)",
                "→ Senior Back-End Developer / Tech Lead"
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
                    setTextColor(Color.parseColor("#10B981"))  // Hijau untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#E6FFFA"))  // Hijau muda background
                setTextColor(Color.parseColor("#10B981"))  // Hijau teks
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