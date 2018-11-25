package com.halim.humtask.domain.entity

import android.os.Parcel
import android.os.Parcelable


data class Question(
    val id: Long = 0,
    val title: String,
    val description: String,
    val numOfAnswers: Int = 0
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        "", "", 0
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }
}