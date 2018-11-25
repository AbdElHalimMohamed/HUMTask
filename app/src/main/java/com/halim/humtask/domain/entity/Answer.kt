package com.halim.humtask.domain.entity

import android.os.Parcel
import android.os.Parcelable


data class Answer(
    val id: Long = 0,
    val parentId: Long,
    val description: String,
    val numOfSubAnswers: Int = 0,
    val parentType: ElementType
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        0,
        "",
        0,
        ElementType.Question
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Answer> {
        override fun createFromParcel(parcel: Parcel): Answer {
            return Answer(parcel)
        }

        override fun newArray(size: Int): Array<Answer?> {
            return arrayOfNulls(size)
        }
    }
}