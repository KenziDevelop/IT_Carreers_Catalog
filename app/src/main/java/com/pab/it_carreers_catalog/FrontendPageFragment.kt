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
import com.pab.it_carreers_catalog.databinding.FragmentFrontEndPageBinding
import android.content.res.ColorStateList

class FrontendPageFragment : Fragment() {

    private var _binding: FragmentFrontEndPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): FrontendPageFragment {
            return FrontendPageFragment().apply {
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
        _binding = FragmentFrontEndPageBinding.inflate(inflater, container, false)
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
                "Bertanggung jawab membangun antarmuka pengguna (UI) yang interaktif, responsif, dan menarik",
                "Bekerja erat dengan desainer UI/UX dan back-end developer untuk mewujudkan desain menjadi kode nyata",
                "Fokus pada performa, aksesibilitas, SEO, dan pengalaman pengguna (UX) di berbagai device",
                "Menggunakan teknologi terbaru untuk menciptakan web/app yang cepat dan modern"
            )
        )
        addChips(listOf("HTML5", "CSS3", "JavaScript", "TypeScript", "React", "Vue.js", "Angular", "Tailwind CSS", "Bootstrap", "Figma"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "HTML5, CSS3 & Responsive Design",
                "JavaScript/TypeScript (ES6+)",
                "Framework/Library (React/Vue/Angular/Svelte)",
                "State Management (Redux, Vuex, Zustand)",
                "CSS-in-JS / Utility-First CSS (Tailwind)",
                "Version Control (Git) & Collaboration",
                "Web Performance & Accessibility (WCAG)"
            )
        )
        addChips(listOf("React", "Vue.js", "TypeScript", "Tailwind CSS", "Next.js", "Vite", "Git", "Responsive Design", "Figma"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Junior Front-End Developer",
                "→ Front-End Developer",
                "→ UI Engineer",
                "→ React/Vue/Angular Specialist",
                "→ Front-End Lead",
                "→ Full-Stack Developer (dengan back-end)"
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
                    setTextColor(Color.parseColor("#6366F1"))  // Biru-ungu untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#E0E7FF"))  // Biru muda background
                setTextColor(Color.parseColor("#6366F1"))  // Biru-ungu teks
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