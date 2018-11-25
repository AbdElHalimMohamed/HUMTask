package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.view.AnswerListView


abstract class BaseAnswerListPresenter<V : AnswerListView>(
    view: V,
    private val getAnswersUseCase: ListAllAnswersUseCase
) : Presenter<V>(view, listOf(getAnswersUseCase)) {

    protected fun loadAnswers(parentId: Long) {

        getAnswersUseCase.execute(parentId, object : SimpleDisposableSubscriber<List<Answer>>(view) {
            override fun onNext(data: List<Answer>) {
                super.onNext(data)

                view?.showAnswers(data)
            }
        })
    }

    fun showAnswerDetails(answer: Answer) {
        view?.openAnswerDetails(answer)
    }
}
