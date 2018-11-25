package com.halim.humtask.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = Answer.TABLE_NAME)
data class Answer(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Element.COLUMN_ID) val id: Long = 0,
    @ColumnInfo(name = COLUMN_QUESTION_PARENT_ID) val questionParentId: Long?,
    @ColumnInfo(name = COLUMN_ANSWER_PARENT_ID) val answerParentId: Long?,
    @ColumnInfo(name = Element.COLUMN_DESCRIPTION) val desc: String?,
    @ColumnInfo(name = Element.COLUMN_ANSWER_NUM) var answerNum: Int?
) {

    companion object {
        const val COLUMN_QUESTION_PARENT_ID = "question_parent_id"
        const val COLUMN_ANSWER_PARENT_ID = "answer_parent_id"
        const val TABLE_NAME = "answer"
    }
}