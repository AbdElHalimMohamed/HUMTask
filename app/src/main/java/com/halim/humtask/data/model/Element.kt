package com.halim.humtask.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey

abstract class Element(
    @PrimaryKey @ColumnInfo(name = COLUMN_ID) val id: Long,
    @ColumnInfo(name = COLUMN_PARENT_ID) val parentId: Long?,
    @ColumnInfo(name = COLUMN_DESCRIPTION) val desc: String?,
    @ColumnInfo(name = COLUMN_ANSWER_NUM) val answerNum: Int?
) {

    companion object {
        const val COLUMN_ID = "_id"
        const val COLUMN_PARENT_ID = "parent_id"
        const val COLUMN_DESCRIPTION = "desc"
        const val COLUMN_ANSWER_NUM = "answer_num"
    }
}