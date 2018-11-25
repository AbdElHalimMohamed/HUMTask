package com.halim.humtask.domain.usecase.question

import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class DeleteQuestionUseCase(
    private val repo: QuestionRepo,
    threadComposer: ThreadComposer
) : UseCase<Int, Long>(threadComposer) {

    override fun buildUseCaseObservable(params: Long): Flowable<Int> =
        repo.deleteQuestion(params).toFlowable()
}