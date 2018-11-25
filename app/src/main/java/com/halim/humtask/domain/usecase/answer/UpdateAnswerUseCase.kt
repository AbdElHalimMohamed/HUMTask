package com.halim.humtask.domain.usecase.answer

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class UpdateAnswerUseCase(
    private val repo: QuestionRepo,
    threadComposer: ThreadComposer
) : UseCase<Int, Question>(threadComposer) {

    override fun buildUseCaseObservable(params: Question): Flowable<Int> =
        repo.updateQuestion(params).toFlowable()
}