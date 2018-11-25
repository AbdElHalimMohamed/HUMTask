package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.usecase.question.ListAllQuestionsUseCase
import com.halim.humtask.domain.view.QuestionListView


class QuestionListPresenter(
    view: QuestionListView,
    private val quesListAllQuestionsUseCase: ListAllQuestionsUseCase
) : Presenter<QuestionListView>(view, listOf(quesListAllQuestionsUseCase)) {


    fun loadQuestions() {

        quesListAllQuestionsUseCase.execute(object : SimpleDisposableSubscriber<List<Question>>(view) {
            override fun onNext(data: List<Question>) {
                super.onNext(data)

                if (data.isEmpty()) {
                    view?.showEmptyResult()
                } else {
                    view?.showQuestions(data)
                }
            }
        })
    }

    fun showDetails(question: Question) {
        view?.showQuestionDetails(question)
    }
}