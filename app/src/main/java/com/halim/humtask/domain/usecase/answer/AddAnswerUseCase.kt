package com.halim.humtask.domain.usecase.answer

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class AddAnswerUseCase(
    private val repo: AnswerRepo,
    threadComposer: ThreadComposer
) : UseCase<Long, Answer>(threadComposer) {

    override fun buildUseCaseObservable(params: Answer): Flowable<Long> =
        repo.addAnswer(params).toFlowable()
}