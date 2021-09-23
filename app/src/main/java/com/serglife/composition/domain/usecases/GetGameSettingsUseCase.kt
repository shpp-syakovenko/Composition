package com.serglife.composition.domain.usecases

import com.serglife.composition.domain.entity.GameSettings
import com.serglife.composition.domain.entity.Level
import com.serglife.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings{
       return repository.getGameSettings(level)
    }
}