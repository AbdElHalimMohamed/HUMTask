package com.halim.humtask.domain.view

import com.halim.humtask.domain.entity.Answer


interface AnswerListView : View {

    fun showAnswers(answers: List<Answer>)

    fun openAnswerDetails(answer: Answer)
}