package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.view.QuestionDetailsView


class QuestionDetailsPresenter(
    view: QuestionDetailsView,
    getAnswersUseCase: ListAllAnswersUseCase,
    private val question: Question
) : BaseAnswerListPresenter<QuestionDetailsView>(view, getAnswersUseCase) {

    fun getQuestionDetails() {
        view?.showQuestion(question)
        loadAnswers(question.id)
    }
}