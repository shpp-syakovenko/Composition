package com.serglife.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serglife.composition.R
import com.serglife.composition.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGameFinishedBinding.inflate(
            inflater,
            container,
            false
        ).also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListener()
        bindViews()
    }

    private fun setupClickListener() {
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    private fun bindViews() {
        binding.emojiResult.setImageResource(getSmileResId())
        binding.tvRequiredAnswers.text = String.format(
            getString(R.string.required_score),
            args.result.gameSettings.minCountOfRightAnswer
        )
        binding.tvScoreAnswers.text = String.format(
            getString(R.string.score_answers),
            args.result.countOfRightAnswers
        )
        binding.tvRequiredPercentage.text = String.format(
            getString(R.string.required_percentage),
            args.result.gameSettings.minPercentOfRightAnswer
        )
        binding.tvScorePercentage.text = String.format(
            getString(R.string.score_percentage),
            getPercentOfRightAnswers()
        )
    }

    private fun getPercentOfRightAnswers() = with(args.result) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }

    private fun getSmileResId(): Int {
        return if (args.result.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }

    private fun retryGame() {
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}