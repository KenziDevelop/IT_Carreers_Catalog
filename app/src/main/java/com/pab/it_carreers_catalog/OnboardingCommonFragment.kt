package com.pab.it_carreers_catalog

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pab.it_carreers_catalog.databinding.FragmentOnboardingCommonBinding

class OnboardingCommonFragment : Fragment() {

    private var _binding: FragmentOnboardingCommonBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_IMAGE = "image"
        private const val ARG_ICON = "icon"
        private const val ARG_COLOR = "color"
        private const val ARG_TITLE = "title"
        private const val ARG_DESC = "desc"
        private const val ARG_IS_LAST = "is_last"

        fun newInstance(
            imageRes: Int,
            iconRes: Int,
            iconColor: String,
            title: String,
            desc: String,
            isLast: Boolean = false
        ): OnboardingCommonFragment {
            return OnboardingCommonFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMAGE, imageRes)
                    putInt(ARG_ICON, iconRes)
                    putString(ARG_COLOR, iconColor)
                    putString(ARG_TITLE, title)
                    putString(ARG_DESC, desc)
                    putBoolean(ARG_IS_LAST, isLast)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingCommonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments ?: return

        // Image
        binding.ivMain.setImageResource(args.getInt(ARG_IMAGE))
        binding.ivIcon.setImageResource(args.getInt(ARG_ICON))

        // Warna icon card
        val colorString = args.getString(ARG_COLOR, "#2196F3") // default biru
        val iconColorInt = try {
            Color.parseColor(colorString)
        } catch (e: IllegalArgumentException) {
            Color.parseColor("#2196F3")
        }

        binding.cardIcon.setCardBackgroundColor(
            ColorStateList.valueOf(iconColorInt)
        )

        // Text
        binding.tvTitle.text = args.getString(ARG_TITLE, "")
        binding.tvDescription.text = args.getString(ARG_DESC, "")

        // Skip
        binding.tvSkip.setOnClickListener {
            (activity as? OnboardingActivity)?.finishOnboarding()
        }

        // Next / Get Started
        val isLast = args.getBoolean(ARG_IS_LAST)
        binding.btnNext.text = if (isLast) "Get Started" else "Next >"

        binding.btnNext.setOnClickListener {
            val act = activity as? OnboardingActivity ?: return@setOnClickListener
            val pager = act.getViewPager()

            if (isLast) {
                act.finishOnboarding()
            } else {
                pager.currentItem += 1
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
