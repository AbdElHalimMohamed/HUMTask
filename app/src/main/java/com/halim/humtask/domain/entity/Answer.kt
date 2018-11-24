package com.halim.humtask.domain.entity


data class Answer(
    val id: Long,
    val parentId: Long,
    val description: String,
    val numOfSubAnswers: Int
)