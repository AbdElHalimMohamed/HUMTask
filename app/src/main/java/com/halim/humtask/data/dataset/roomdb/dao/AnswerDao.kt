package com.halim.humtask.data.dataset.roomdb.dao

import android.arch.persistence.room.*
import com.halim.humtask.data.model.Element
import com.halim.humtask.data.model.Answer
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface AnswerDao {

    @Query("SELECT * from ${Answer.TABLE_NAME}")
    fun getAllAnswers(): Flowable<List<Answer>>

    @Query("SELECT * from ${Answer.TABLE_NAME} WHERE ${Element.COLUMN_PARENT_ID} = :parentId")
    fun getAnswers(parentId: Long): Flowable<List<Answer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnswer(answer: Answer): Single<Long>

    @Update
    fun updateAnswer(answer: Answer): Single<Int>

    @Query("DELETE from ${Answer.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :answerId")
    fun deleteAnswer(answerId: Long): Single<Int>

    @Query("SELECT * from ${Answer.TABLE_NAME} WHERE ${Element.COLUMN_ID} = :answerId")
    fun getAnswerById(answerId: Long): Flowable<Answer>
}