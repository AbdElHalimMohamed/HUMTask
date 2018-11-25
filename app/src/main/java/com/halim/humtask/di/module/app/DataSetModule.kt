package com.halim.humtask.di.module.app

import android.content.Context
import com.halim.humtask.data.dataset.AnswersDataSet
import com.halim.humtask.data.dataset.QuestionsDataSet
import com.halim.humtask.data.dataset.roomdb.DataSetRoomDB
import com.halim.humtask.data.dataset.roomdb.RoomDBAnswersDataSet
import com.halim.humtask.data.dataset.roomdb.RoomDBQuestionsDataSet
import com.halim.humtask.data.dataset.roomdb.dao.AnswerDao
import com.halim.humtask.data.dataset.roomdb.dao.QuestionDao
import com.halim.humtask.di.qualifier.AppQualifier
import com.halim.humtask.di.scope.AppScope
import dagger.Module
import dagger.Provides


@Module
class DataSetModule {

    @AppScope
    @Provides
    fun provideRoonDB(@AppQualifier context: Context): DataSetRoomDB =
        DataSetRoomDB.getInstance(context)

    @AppScope
    @Provides
    fun provideAnswerDao(roomDB: DataSetRoomDB): AnswerDao =
        roomDB.getAnswerDao()

    @AppScope
    @Provides
    fun provideQuestionDao(roomDB: DataSetRoomDB): QuestionDao =
        roomDB.getQuestionDao()

    @AppScope
    @Provides
    fun provideRoomDBAnswersDataSet(dao: AnswerDao): AnswersDataSet =
        RoomDBAnswersDataSet(dao)

    @AppScope
    @Provides
    fun provideRoomDBQuestionDataSet(dao: QuestionDao): QuestionsDataSet =
        RoomDBQuestionsDataSet(dao)
}