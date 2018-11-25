package com.halim.humtask.domain.view

import com.halim.humtask.domain.entity.Answer


interface AnswerDetailsView : AnswerListView {

    fun showAnswer(answer: Answer)

    fun openAddAnswer(answer: Answer)
}