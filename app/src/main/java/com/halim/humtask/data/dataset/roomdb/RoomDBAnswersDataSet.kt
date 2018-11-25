package com.halim.humtask.data.dataset.roomdb

import com.halim.humtask.data.dataset.AnswersDataSet
import com.halim.humtask.data.dataset.roomdb.dao.AnswerDao
import com.halim.humtask.data.model.Answer
import io.reactivex.Flowable
import io.reactivex.Single


class RoomDBAnswersDataSet(private val dao: AnswerDao) : AnswersDataSet {

    override fun listAnswers(questionId: Long): Flowable<List<Answer>> =
        dao.getAnswers(questionId)

    override fun listSubAnswers(answersId: Long): Flowable<List<Answer>> =
        dao.getSubAnswers(answersId)

    override fun getAnswer(answerId: Long): Flowable<Answer> =
        dao.getAnswerById(answerId)

    override fun addAnswer(answer: Answer): Single<Long> =
        Single.fromCallable { dao.addAnswer(answer) }

    override fun deleteAnswer(answerId: Long): Single<Int> =
        Single.fromCallable { dao.deleteAnswer(answerId) }

    override fun updateAnswer(answer: Answer): Single<Int> =
        Single.fromCallable { dao.updateAnswer(answer) }
}