package com.halim.humtask.domain.usecase.answer

import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class GetAnswerUseCase(
    private val repo: AnswerRepo,
    threadComposer: ThreadComposer
) : UseCase<Answer, Long>(threadComposer) {

    override fun buildUseCaseObservable(params: Long): Flowable<Answer> =
        repo.getAnswer(params)
}