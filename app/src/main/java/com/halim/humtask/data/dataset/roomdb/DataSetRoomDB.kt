package com.halim.humtask.data.dataset.roomdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.halim.humtask.data.dataset.roomdb.dao.AnswerDao
import com.halim.humtask.data.dataset.roomdb.dao.QuestionDao
import com.halim.humtask.data.model.Answer
import com.halim.humtask.data.model.Question

@Database(
    version = DataSetRoomDB.DB_VERSION,
    entities = [Question::class, Answer::class]
)
abstract class DataSetRoomDB : RoomDatabase() {

    abstract fun getQuestionDao(): QuestionDao

    abstract fun getAnswerDao(): AnswerDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "qs_as_db"

        private var INSTANCE: DataSetRoomDB? = null

        fun getInstance(context: Context): DataSetRoomDB =
            INSTANCE ?: synchronized(DataSetRoomDB::class) {
                Room.databaseBuilder(
                    context,
                    DataSetRoomDB::class.java, DB_NAME
                ).build().also {
                    INSTANCE = it
                }
            }
    }
}