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
import com.pab.it_carreers_catalog.databinding.FragmentCyberSecurityPageBinding
import android.content.res.ColorStateList

class CyberSecurityPageFragment : Fragment() {

    private var _binding: FragmentCyberSecurityPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): CyberSecurityPageFragment {
            return CyberSecurityPageFragment().apply {
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
        _binding = FragmentCyberSecurityPageBinding.inflate(inflater, container, false)
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
                "Melindungi sistem, jaringan, dan data dari serangan cyber seperti ransomware, phishing, dan DDoS",
                "Melakukan penetration testing, vulnerability scanning, dan ethical hacking untuk menemukan celah keamanan",
                "Merespon insiden keamanan (incident response), forensic digital, dan recovery setelah serangan",
                "Memastikan kepatuhan terhadap regulasi seperti GDPR, ISO 27001, dan standar keamanan nasional"
            )
        )
        addChips(listOf("Firewall", "IDS/IPS", "SIEM", "Kali Linux", "Metasploit", "Burp Suite", "Wireshark", "Nessus"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Network & Web Security",
                "Penetration Testing & Ethical Hacking",
                "Threat Intelligence & Analysis",
                "Incident Response & Forensics",
                "Cryptography & Secure Coding",
                "Compliance & Risk Management"
            )
        )
        addChips(listOf("CEH (Certified Ethical Hacker)", "OSCP", "CISSP", "CompTIA Security+", "Penetration Testing", "SIEM Tools", "Firewall Management", "Malware Analysis"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Security Analyst / SOC Analyst",
                "→ Penetration Tester / Red Teamer",
                "→ Security Engineer",
                "→ Incident Responder",
                "→ Chief Information Security Officer (CISO)",
                "→ Cyber Security Consultant"
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
                    setTextColor(Color.parseColor("#EF4444"))  // Merah untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#FEE2E2"))  // Merah muda background
                setTextColor(Color.parseColor("#EF4444"))  // Merah teks
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