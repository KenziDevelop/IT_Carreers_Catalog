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
import com.pab.it_carreers_catalog.databinding.FragmentNetworkEngineerPageBinding
import android.content.res.ColorStateList

class NetworkEngineerPageFragment : Fragment() {

    private var _binding: FragmentNetworkEngineerPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): NetworkEngineerPageFragment {
            return NetworkEngineerPageFragment().apply {
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
        _binding = FragmentNetworkEngineerPageBinding.inflate(inflater, container, false)
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
                "Merancang, mengimplementasikan, dan memelihara infrastruktur jaringan perusahaan (LAN, WAN, Data Center)",
                "Memastikan konektivitas stabil, aman, dan berkinerja tinggi untuk seluruh pengguna dan layanan",
                "Menangani konfigurasi router, switch, firewall, VPN, serta troubleshooting masalah jaringan",
                "Mengimplementasikan solusi SD-WAN, cloud networking, dan keamanan jaringan"
            )
        )
        addChips(listOf("Cisco", "Juniper", "Routing (OSPF/BGP)", "Switching", "Firewall", "VPN", "SD-WAN", "Wireshark"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Network Design & Architecture",
                "Routing & Switching Protocols",
                "Network Security & Firewall",
                "Troubleshooting & Monitoring",
                "VPN & Remote Access",
                "Cloud Networking (AWS/Azure/GCP)",
                "SD-WAN & Automation"
            )
        )
        addChips(listOf("Cisco CCNA/CCNP", "Juniper JNCIA", "OSPF/BGP", "VLAN & Trunking", "Firewall (Palo Alto/Fortinet)", "Wireshark", "SD-WAN", "Python for Network Automation"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Junior Network Engineer",
                "→ Network Administrator",
                "→ Network Security Engineer",
                "→ NOC Engineer",
                "→ Network Architect",
                "→ Infrastructure Engineer",
                "→ SD-WAN Specialist"
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
                    setTextColor(Color.parseColor("#06B6D4"))  // Cyan untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#CFFAFE"))  // Cyan muda background
                setTextColor(Color.parseColor("#06B6D4"))  // Cyan teks
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