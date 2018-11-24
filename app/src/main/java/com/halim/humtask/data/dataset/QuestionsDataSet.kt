package com.halim.humtask.data.dataset

import com.halim.humtask.data.model.Answer
import com.halim.humtask.data.model.Question
import io.reactivex.Flowable
import io.reactivex.Single


interface QuestionsDataSet {

    fun listAllQuestions(): Flowable<List<Question>>

    fun getQuestion(questionId: Long): Flowable<Question>

    fun addAnswer(question: Question, answer: Answer): Single<Long>

    fun addQuestion(question: Question): Single<Long>

    fun deleteQuestion(questionId: Long): Single<Int>

    fun updateQuestion(question: Question): Single<Int>
}