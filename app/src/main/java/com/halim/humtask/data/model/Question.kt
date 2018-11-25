package com.halim.humtask.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = Question.TABLE_NAME)
data class Question(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Element.COLUMN_ID) val id: Long = 0,
    @ColumnInfo(name = COLUMN_TITLE) val title: String?,
    @ColumnInfo(name = Element.COLUMN_DESCRIPTION) val desc: String?,
    @ColumnInfo(name = Element.COLUMN_ANSWER_NUM) var answerNum: Int?
) {
    companion object {
        const val TABLE_NAME = "question"
        const val COLUMN_TITLE = "title"
    }
}