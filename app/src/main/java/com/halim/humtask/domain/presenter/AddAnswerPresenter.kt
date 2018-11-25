package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.entity.ElementType
import com.halim.humtask.domain.usecase.answer.AddAnswerUseCase
import com.halim.humtask.domain.usecase.observers.SimpleDisposableSubscriber
import com.halim.humtask.domain.view.View


class AddAnswerPresenter(
    view: View,
    private val addAnswerUseCase: AddAnswerUseCase,
    private val parentId: Long,
    private val parentType: ElementType
) : Presenter<View>(view, listOf(addAnswerUseCase)) {

    fun addAnswer(
        desc: String
    ) {
        addAnswerUseCase.execute(
            Answer(
                parentId = parentId,
                description = desc,
                parentType = parentType
            ),
            object : SimpleDisposableSubscriber<Long>(view) {
                override fun onNext(data: Long) {
                    super.onNext(data)

                    view?.close()
                }
            })
    }
}