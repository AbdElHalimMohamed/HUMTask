package com.halim.humtask.domain.view

import com.halim.humtask.domain.entity.Question


interface QuestionListView : View {

    fun showQuestions(questions: List<Question>)

    fun showQuestionDetails(question: Question)
}