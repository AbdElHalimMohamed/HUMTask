package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.entity.ElementType
import com.halim.humtask.domain.usecase.answer.GetAnswerUseCase
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.view.AnswerDetailsView


class AnswerDetailsPresenter(
    view: AnswerDetailsView,
    getAnswersUseCase: ListAllAnswersUseCase,
    private val getAnswerUseCase: GetAnswerUseCase,
    private val answer: Answer
) : BaseAnswerListPresenter<AnswerDetailsView>(
    view, getAnswersUseCase,
    answer.id, ElementType.Answer
) {

    fun getAnswerDetails() {
        getAnswerUseCase.execute(answer.id, object : SimpleDisposableSubscriber<Answer>(view) {
            override fun onNext(data: Answer) {
                super.onNext(data)

                view?.showAnswer(data)
            }
        })
        loadAnswers(answer.id)
    }

    override fun addAnswer() {
        view?.openAddAnswer(answer)
    }
}