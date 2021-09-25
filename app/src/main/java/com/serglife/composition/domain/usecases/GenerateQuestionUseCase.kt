package com.serglife.composition.domain.usecases

import com.serglife.composition.domain.entity.Question
import com.serglife.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(maxValue: Int): Question {
        return repository.generateQuestion(maxValue, COUNT_OF_OPTIONS)
    }

    companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}