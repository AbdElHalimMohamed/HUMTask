package com.halim.humtask.domain.repository

import com.halim.humtask.domain.entity.Answer
import io.reactivex.Flowable
import io.reactivex.Single


interface AnswerRepo {

    fun listAnswers(elementId: Long): Flowable<List<Answer>>

    fun getAnswer(answerId: Long): Flowable<Answer>

    fun addAnswer(answer: Answer): Single<Long>

    fun updateAnswer(answer: Answer): Single<Int>

    fun deleteAnswer(answerId: Long): Single<Int>
}