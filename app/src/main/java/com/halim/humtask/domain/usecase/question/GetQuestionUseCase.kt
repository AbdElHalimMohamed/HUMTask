package com.halim.humtask.domain.usecase.question

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.UseCase
import io.reactivex.Flowable


class GetQuestionUseCase(
    private val repo: QuestionRepo,
    threadComposer: ThreadComposer
) : UseCase<Question, Long>(threadComposer) {

    override fun buildUseCaseObservable(params: Long): Flowable<Question> =
        repo.getQuestion(params)
}