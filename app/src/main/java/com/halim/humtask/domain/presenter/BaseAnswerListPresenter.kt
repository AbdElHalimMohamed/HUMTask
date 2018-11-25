package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.entity.ElementType
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.view.AnswerListView


abstract class BaseAnswerListPresenter<V : AnswerListView>(
    view: V,
    private val getAnswersUseCase: ListAllAnswersUseCase,
    private val parentId: Long,
    private val parentType: ElementType
) : Presenter<V>(view, listOf(getAnswersUseCase)) {

    protected fun loadAnswers(parentId: Long) {

        getAnswersUseCase.execute(ListAllAnswersUseCase.Params(parentId, parentType),
            object : SimpleDisposableSubscriber<List<Answer>>(view) {
                override fun onNext(data: List<Answer>) {
                    super.onNext(data)

                    view?.showAnswers(data)
                }
            })
    }

    fun showAnswerDetails(answer: Answer) {
        view?.openAnswerDetails(answer)
    }

    abstract fun addAnswer()
}
