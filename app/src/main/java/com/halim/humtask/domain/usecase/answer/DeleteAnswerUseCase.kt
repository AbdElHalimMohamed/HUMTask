package com.halim.humtask.domain.usecase.answer

import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class DeleteAnswerUseCase(
    private val repo: AnswerRepo,
    threadComposer: ThreadComposer
) : UseCase<Int, Long>(threadComposer) {

    override fun buildUseCaseObservable(params: Long): Flowable<Int> =
        repo.deleteAnswer(params).toFlowable()
}