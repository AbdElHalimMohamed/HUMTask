package com.halim.humtask.data.repository

import com.halim.humtask.data.dataset.QuestionsDataSet
import com.halim.humtask.domain.repository.QuestionRepo
import io.reactivex.Flowable
import io.reactivex.Single
import com.halim.humtask.data.model.Question as QuestionModel
import com.halim.humtask.domain.entity.Question as QuestionEntity


class QuestionRepoImp(private val dataSet: QuestionsDataSet) : QuestionRepo {

    override fun listAllQuestions(): Flowable<List<QuestionEntity>> =
        dataSet.listAllQuestions().map { questinos ->
            questinos.map {
                it.toEntity()
            }
        }

    override fun getQuestion(questionId: Long): Flowable<QuestionEntity> =
        dataSet.getQuestion(questionId).map {
            it.toEntity()
        }

    override fun deleteQuestion(questionId: Long): Single<Int> =
        dataSet.deleteQuestion(questionId)

    override fun updateQuestion(question: QuestionEntity): Single<Int> =
        dataSet.updateQuestion(question.toModel())

    override fun addQuestion(question: QuestionEntity): Single<Long> =
        dataSet.addQuestion(question.toModel())


    private fun QuestionModel.toEntity(): QuestionEntity =
        QuestionEntity(
            id,
            title ?: "",
            desc ?: "",
            answerNum ?: 0
        )

    private fun QuestionEntity.toModel(): QuestionModel =
        QuestionModel(id, title, description, numOfAnswers)
}