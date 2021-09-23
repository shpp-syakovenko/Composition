package com.serglife.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.serglife.composition.R
import com.serglife.composition.databinding.FragmentWelcomeBinding
import java.lang.RuntimeException

class WelcomeFragment: Fragment() {
    private var _binding : FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
    get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentWelcomeBinding.inflate(inflater, container, false).also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonUnderstand.setOnClickListener{

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}