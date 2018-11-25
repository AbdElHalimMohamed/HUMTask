package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.usecase.question.AddQuestionUseCase
import com.halim.humtask.domain.view.View


class AddQuestionPresenter(
    view: View,
    private val addQuestionUseCase: AddQuestionUseCase
) : Presenter<View>(view, listOf(addQuestionUseCase)) {

    fun addQuestion(
        title: String,
        desc: String
    ) {
        addQuestionUseCase.execute(Question(title = title, description = desc),
            object : SimpleDisposableSubscriber<Long>(view) {
                override fun onNext(data: Long) {
                    super.onNext(data)

                    view?.close()
                }
            })
    }
}