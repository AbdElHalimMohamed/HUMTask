package com.halim.humtask.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(
    tableName = Answer.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = Answer::class,
        parentColumns = [Element.COLUMN_ID],
        childColumns = [Element.COLUMN_PARENT_ID],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Question::class,
        parentColumns = [Element.COLUMN_ID],
        childColumns = [Element.COLUMN_PARENT_ID],
        onDelete = ForeignKey.CASCADE
    )]
)
class Answer(
    id: Long,
    parentId: Long?,
    desc: String?,
    answerNum: Int?
) : Element(id, parentId, desc, answerNum) {

    companion object {
        const val TABLE_NAME = "answer"
    }
}