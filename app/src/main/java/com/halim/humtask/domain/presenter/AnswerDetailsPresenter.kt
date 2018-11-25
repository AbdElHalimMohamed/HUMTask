package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.view.AnswerDetailsView


class AnswerDetailsPresenter(
    view: AnswerDetailsView,
    getAnswersUseCase: ListAllAnswersUseCase,
    private val answer: Answer
) : BaseAnswerListPresenter<AnswerDetailsView>(view, getAnswersUseCase) {

    fun getAnswerDetails() {
        view?.showAnswer(answer)
        loadAnswers(answer.id)
    }
}