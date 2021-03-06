package com.halim.humtask.data.dataset.roomdb

import com.halim.humtask.data.dataset.QuestionsDataSet
import com.halim.humtask.data.dataset.roomdb.dao.QuestionDao
import com.halim.humtask.data.model.Question
import io.reactivex.Flowable
import io.reactivex.Single


class RoomDBQuestionsDataSet(private val dao: QuestionDao) : QuestionsDataSet {

    override fun listAllQuestions(): Flowable<List<Question>> =
        dao.getAllQuestions()

    override fun getQuestion(questionId: Long): Flowable<Question> =
        dao.getQuestionById(questionId)

    override fun addQuestion(question: Question): Single<Long> =
        Single.fromCallable { dao.insertQuestion(question) }

    override fun deleteQuestion(questionId: Long): Single<Int> =
        Single.fromCallable { dao.deleteQuestion(questionId) }

    override fun updateQuestion(question: Question): Single<Int> =
        Single.fromCallable { dao.updateQuestion(question) }
}