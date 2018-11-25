package com.halim.humtask.data.dataset

import com.halim.humtask.data.model.Answer
import io.reactivex.Flowable
import io.reactivex.Single


interface AnswersDataSet {

    fun listAnswers(questionId: Long): Flowable<List<Answer>>

    fun listSubAnswers(answersId: Long): Flowable<List<Answer>>

    fun getAnswer(answerId: Long): Flowable<Answer>

    fun addAnswer(answer: Answer): Single<Long>

    fun deleteAnswer(answerId: Long): Single<Int>

    fun updateAnswer(answer: Answer): Single<Int>
}