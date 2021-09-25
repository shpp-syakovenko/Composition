package com.serglife.composition.domain.repository

import com.serglife.composition.domain.entity.GameSettings
import com.serglife.composition.domain.entity.Level
import com.serglife.composition.domain.entity.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}