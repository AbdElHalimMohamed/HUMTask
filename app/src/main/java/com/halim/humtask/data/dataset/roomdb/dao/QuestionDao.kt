package com.halim.humtask.data.dataset.roomdb.dao

import android.arch.persistence.room.*
import com.halim.humtask.data.model.Answer
import com.halim.humtask.data.model.Element
import com.halim.humtask.data.model.Question
import io.reactivex.Flowable


@Dao
interface QuestionDao {

    @Query("SELECT * from ${Question.TABLE_NAME}")
    fun getAllQuestions(): Flowable<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuestion(question: Question): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnswer(answer: Answer): Long

    @Update
    fun updateQuestion(question: Question): Int

    @Query("DELETE from ${Question.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :questionId")
    fun deleteQuestion(questionId: Long): Int

    @Query("SELECT * from ${Question.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :questionId")
    fun getQuestionById(questionId: Long): Flowable<Question>
}