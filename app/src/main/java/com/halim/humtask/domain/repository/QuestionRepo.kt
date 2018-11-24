package com.halim.humtask.domain.repository

import com.halim.humtask.domain.entity.Question
import io.reactivex.Flowable
import io.reactivex.Single


interface QuestionRepo {

    fun listAllQuestions(): Flowable<List<Question>>

    fun getQuestion(questionId: Long): Flowable<Question>

    fun deleteQuestion(questionId: Long): Single<Int>

    fun updateQuestion(question: Question): Single<Int>

    fun addQuestion(question: Question): Single<Long>
}