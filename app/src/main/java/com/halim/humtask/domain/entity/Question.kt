package com.halim.humtask.domain.entity


data class Question(
    val id: Long,
    val title: String,
    val description: String,
    val numOfAnswers: Int
)