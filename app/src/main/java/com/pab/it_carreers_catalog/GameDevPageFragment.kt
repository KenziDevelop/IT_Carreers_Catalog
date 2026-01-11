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
import com.pab.it_carreers_catalog.databinding.FragmentGameDevPageBinding
import android.content.res.ColorStateList

class GameDevPageFragment : Fragment() {

    private var _binding: FragmentGameDevPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PAGE_TYPE = "page_type"

        fun newInstance(pageType: String): GameDevPageFragment {
            return GameDevPageFragment().apply {
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
        _binding = FragmentGameDevPageBinding.inflate(inflater, container, false)
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
                "Mendesain, memprogram, dan mengembangkan video game untuk berbagai platform (PC, console, mobile, VR/AR)",
                "Menggabungkan programming, seni 2D/3D, animasi, sound design, dan storytelling untuk menciptakan pengalaman interaktif",
                "Bekerja dalam tim kreatif (programmer, artist, designer, QA) untuk membangun game dari konsep hingga rilis",
                "Menggunakan game engine seperti Unity atau Unreal Engine untuk prototyping cepat dan deployment multi-platform"
            )
        )
        addChips(listOf("Unity", "Unreal Engine", "C#", "C++", "Godot", "Blender", "Photoshop", "Substance Painter", "FMOD"))
    }

    private fun setupSkills() {
        binding.tvSectionTitle.text = "Key Skills Required"
        addBulletPoints(
            listOf(
                "Game Programming (C#/C++)",
                "Game Engine Mastery (Unity/Unreal/Godot)",
                "3D Modeling & Animation",
                "Physics & Math for Games",
                "UI/UX for Games",
                "Multiplayer & Networking",
                "Optimization & Performance"
            )
        )
        addChips(listOf("Unity", "Unreal Engine", "C#", "C++", "Blueprint", "3D Modeling", "Shader Programming", "Git"))
    }

    private fun setupCareers() {
        binding.tvSectionTitle.text = "Career Opportunities"
        addBulletPoints(
            listOf(
                "→ Gameplay Programmer",
                "→ Unity/Unreal Developer",
                "→ Game Designer",
                "→ Technical Artist",
                "→ Tools Programmer",
                "→ VR/AR Developer",
                "→ Indie Game Developer"
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
                    setTextColor(Color.parseColor("#FB923C"))  // Oranye untuk link
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
                chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#FFF7ED"))  // Oranye muda background
                setTextColor(Color.parseColor("#FB923C"))  // Oranye teks
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