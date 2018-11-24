package com.halim.humtask.data.dataset

import com.halim.humtask.data.model.Answer
import io.reactivex.Flowable
import io.reactivex.Single


interface AnswersDataSet {

    fun listAnswers(parentId: Long): Flowable<List<Answer>>

    fun getAnswer(answerId: Long): Flowable<Answer>

    fun addSubAnswer(answer: Answer, subAnswer: Answer): Single<Long>

    fun deleteAnswer(answerId: Long): Single<Int>

    fun updateAnswer(answer: Answer): Single<Int>
}