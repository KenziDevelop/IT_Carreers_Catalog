package com.pab.it_carreers_catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.pab.it_carreers_catalog.databinding.FragmentCloudEngineerPageBinding
import android.graphics.Color
import android.graphics.Paint
import android.widget.LinearLayout
import android.widget.TextView
import android.content.res.ColorStateList

class CloudEngineerPageFragment : Fragment() {

    private var _binding: FragmentCloudEngineerPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): CloudEngineerPageFragment {
            return CloudEngineerPageFragment().apply {
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
        _binding = FragmentCloudEngineerPageBinding.inflate(inflater, container, false)
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
                "Merancang, mengimplementasikan, dan mengelola infrastruktur cloud (AWS, Azure, GCP)",
                "Mengoptimalkan skalabilitas, keamanan, performa, dan biaya layanan cloud",
                "Mengintegrasikan CI/CD pipeline dan praktik DevOps untuk deployment cepat & aman",
                "Monitoring, logging, dan troubleshooting infrastruktur cloud secara real-time"
            )
        )
        addChips(listOf("AWS", "Azure", "Google Cloud", "Terraform", "Kubernetes", "Docker", "Jenkins", "CI/CD", "Cloud Security"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Cloud Architecture & Design",
                "Infrastructure as Code (IaC)",
                "Containerization & Orchestration",
                "CI/CD Pipeline & Automation",
                "Cloud Security & Compliance",
                "Monitoring & Logging Tools",
                "Scripting (Python/Bash)"
            )
        )
        addChips(listOf("AWS Certified Solutions Architect", "Azure Administrator", "Google Cloud Professional", "Terraform", "Kubernetes (CKA)", "Docker", "Jenkins/GitHub Actions", "Prometheus/Grafana", "Serverless"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Cloud Architect",
                "→ DevOps Engineer",
                "→ Site Reliability Engineer (SRE)",
                "→ Platform Engineer",
                "→ Cloud Security Engineer",
                "→ Cloud Consultant / Solutions Architect"
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
                    setTextColor(Color.parseColor("#3B82F6"))  // Biru link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#DBEAFE"))
                setTextColor(Color.parseColor("#3B82F6"))
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