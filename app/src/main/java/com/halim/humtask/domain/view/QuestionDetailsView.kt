package com.halim.humtask.domain.view

import com.halim.humtask.domain.entity.Question


interface QuestionDetailsView : AnswerListView {

    fun showQuestion(question: Question)
}