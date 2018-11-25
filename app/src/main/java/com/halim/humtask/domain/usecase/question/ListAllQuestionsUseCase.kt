package com.halim.humtask.domain.usecase.question

import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.NoParamsUseCase
import io.reactivex.Flowable


class ListAllQuestionsUseCase(
    private val repo: QuestionRepo,
    threadComposer: ThreadComposer
) : NoParamsUseCase<List<Question>>(threadComposer) {

    override fun buildUseCaseObservable(): Flowable<List<Question>> =
        repo.listAllQuestions()
}