package com.halim.humtask.data.dataset.roomdb.dao

import android.arch.persistence.room.*
import com.halim.humtask.data.model.Answer
import com.halim.humtask.data.model.Element
import com.halim.humtask.data.model.Question
import io.reactivex.Flowable


@Dao
interface AnswerDao {

    @Query("SELECT * from ${Answer.TABLE_NAME}")
    fun getAllAnswers(): Flowable<List<Answer>>

    @Query("SELECT * from ${Answer.TABLE_NAME} WHERE ${Answer.COLUMN_QUESTION_PARENT_ID} = :parentId")
    fun getAnswers(parentId: Long): Flowable<List<Answer>>

    @Query("SELECT * from ${Answer.TABLE_NAME} WHERE ${Answer.COLUMN_ANSWER_PARENT_ID} = :parentId")
    fun getSubAnswers(parentId: Long): Flowable<List<Answer>>

    @Query("SELECT * from ${Answer.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :answerId")
    fun getAnswerById(answerId: Long): Flowable<Answer>

    @Transaction
    fun addAnswer(answer: Answer): Long {
        var parentAnswer: Answer? = answer
        while (getAnswerByIdBlocking(parentAnswer?.answerParentId ?: -1)?.also { parentAnswer = it } != null) {
            parentAnswer?.let {
                it.answerNum?.let { num -> it.answerNum = num.inc() }
                updateAnswer(it)
            }
        }

        insertAnswer(answer)

        val parentQuestion = getQuestionById(parentAnswer?.questionParentId ?: -1)
        parentQuestion.answerNum?.let { num -> parentQuestion.answerNum = num.inc() }
        updateQuestion(parentQuestion)

        return answer.id
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnswer(answer: Answer): Long

    @Update
    fun updateAnswer(answer: Answer): Int

    @Query("DELETE from ${Answer.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :answerId")
    fun deleteAnswer(answerId: Long): Int

    @Query("SELECT * from ${Answer.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :answerId")
    fun getAnswerByIdBlocking(answerId: Long): Answer?



    @Query("SELECT * from ${Question.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :questionId")
    fun getQuestionById(questionId: Long): Question

    @Update
    fun updateQuestion(question: Question): Int
}