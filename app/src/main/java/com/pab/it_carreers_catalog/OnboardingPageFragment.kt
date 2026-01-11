package com.pab.it_carreers_catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pab.it_carreers_catalog.databinding.FragmentOnboardingCommonBinding

class OnboardingPageFragment : Fragment() {

    private var _binding: FragmentOnboardingCommonBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(imageRes: Int, title: String, description: String) = OnboardingPageFragment().apply {
            arguments = Bundle().apply {
                putInt("image", imageRes)
                putString("title", title)
                putString("description", description)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOnboardingCommonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            binding.ivMain.setImageResource(it.getInt("image"))
            binding.tvTitle.text = it.getString("title")
            binding.tvDescription.text = it.getString("description")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}