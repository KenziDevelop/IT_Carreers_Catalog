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
import com.pab.it_carreers_catalog.databinding.FragmentUiUxDesignerPageBinding
import android.content.res.ColorStateList

class UiUxDesignerPageFragment : Fragment() {

    private var _binding: FragmentUiUxDesignerPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): UiUxDesignerPageFragment {
            return UiUxDesignerPageFragment().apply {
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
        _binding = FragmentUiUxDesignerPageBinding.inflate(inflater, container, false)
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
                "Merancang antarmuka pengguna (UI) yang estetis dan pengalaman pengguna (UX) yang intuitif serta menyenangkan",
                "Melakukan riset pengguna, membuat wireframe, prototype, dan melakukan usability testing",
                "Bekerja sama dengan product manager, developer, dan stakeholder untuk mewujudkan produk digital terbaik",
                "Memastikan desain responsif, accessible (WCAG), dan sesuai brand identity"
            )
        )
        addChips(listOf("Figma", "Adobe XD", "Sketch", "Framer", "Principle", "InVision Studio", "Miro", "User Testing"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "User Research & Personas",
                "Wireframing & Information Architecture",
                "Prototyping & Interaction Design",
                "Visual UI Design",
                "Usability Testing & Iteration",
                "Design Systems & Component Library",
                "Accessibility & Responsive Design"
            )
        )
        addChips(listOf("Figma", "Adobe XD", "Sketch", "Framer", "Miro", "User Testing", "Design System", "WCAG"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Junior UI/UX Designer",
                "→ UI Designer",
                "→ UX Designer",
                "→ Product Designer",
                "→ Interaction Designer",
                "→ UX Researcher",
                "→ Design Lead / Head of Design"
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
                    setTextColor(Color.parseColor("#F472B6"))  // Pink muda untuk link
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
                setTextColor(Color.parseColor("#F472B6"))  // Pink teks
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