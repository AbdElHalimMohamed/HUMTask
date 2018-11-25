package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.ElementType
import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.usecase.question.GetQuestionUseCase
import com.halim.humtask.domain.view.QuestionDetailsView


class QuestionDetailsPresenter(
    view: QuestionDetailsView,
    getAnswersUseCase: ListAllAnswersUseCase,
    private val getQuestionUseCase: GetQuestionUseCase,
    private val question: Question
) : BaseAnswerListPresenter<QuestionDetailsView>(
    view, getAnswersUseCase,
    question.id, ElementType.Question
) {

    fun getQuestionDetails() {
        getQuestionUseCase.execute(question.id, object : SimpleDisposableSubscriber<Question>(view) {
            override fun onNext(data: Question) {
                super.onNext(data)

                view?.showQuestion(data)
            }
        })
        loadAnswers(question.id)
    }

    override fun addAnswer() {
        view?.openAddAnswer(question)
    }
}