package com.halim.humtask.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = Question.TABLE_NAME)
class Question(
    id: Long,
    @ColumnInfo(name = COLUMN_TITLE) val title: String?,
    desc: String?,
    answerNum: Int?
) : Element(id, null, desc, answerNum) {

    companion object {
        const val TABLE_NAME = "question"
        const val COLUMN_TITLE = "title"
    }
}