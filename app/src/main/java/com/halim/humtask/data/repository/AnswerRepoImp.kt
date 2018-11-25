package com.halim.humtask.data.repository

import com.halim.humtask.data.dataset.AnswersDataSet
import com.halim.humtask.domain.entity.ElementType
import com.halim.humtask.domain.repository.AnswerRepo
import io.reactivex.Flowable
import io.reactivex.Single
import com.halim.humtask.data.model.Answer as AnswerModel
import com.halim.humtask.domain.entity.Answer as AnswerEntity


class AnswerRepoImp(private val dataSet: AnswersDataSet) : AnswerRepo {

    override fun listAnswers(elementId: Long, elementType: ElementType)
            : Flowable<List<AnswerEntity>> =
        when (elementType) {
            ElementType.Question -> dataSet.listAnswers(elementId)
            ElementType.Answer -> dataSet.listSubAnswers(elementId)
        }.map { answers ->
            answers.map {
                it.toEntity()
            }
        }

    override fun getAnswer(answerId: Long): Flowable<AnswerEntity> =
        dataSet.getAnswer(answerId).map {
            it.toEntity()
        }

    override fun deleteAnswer(answerId: Long): Single<Int> =
        dataSet.deleteAnswer(answerId)

    override fun updateAnswer(answer: AnswerEntity): Single<Int> =
        dataSet.updateAnswer(answer.toModel())

    override fun addAnswer(answer: AnswerEntity): Single<Long> =
        dataSet.addAnswer(answer.toModel())

    private fun AnswerModel.toEntity(): AnswerEntity =
        AnswerEntity(
            id,
            questionParentId ?: answerParentId ?: -1,
            desc ?: "",
            answerNum ?: 0,
            questionParentId?.let { ElementType.Question }
                ?: ElementType.Answer)

    private fun AnswerEntity.toModel(): AnswerModel =
        AnswerModel(
            id,
            if (parentType == ElementType.Question) parentId else -1,
            if (parentType == ElementType.Answer) parentId else -1,
            description, numOfSubAnswers
        )
}