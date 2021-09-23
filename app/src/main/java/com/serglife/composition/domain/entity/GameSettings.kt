package com.serglife.composition.domain.entity

data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswer: Int,
    val minPercentOfRightAnswer: Int,
    val gameTimeSecond: Int
)