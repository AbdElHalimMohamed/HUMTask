package com.halim.humtask.domain.usecase.question

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class AddQuestionUseCase(
    private val repo: QuestionRepo,
    threadComposer: ThreadComposer
) : UseCase<Long, Question>(threadComposer) {

    override fun buildUseCaseObservable(params: Question): Flowable<Long> =
        repo.addQuestion(params).toFlowable()
}