package com.halim.humtask.di.module.app

import com.halim.humtask.data.dataset.AnswersDataSet
import com.halim.humtask.data.dataset.QuestionsDataSet
import com.halim.humtask.data.repository.AnswerRepoImp
import com.halim.humtask.data.repository.QuestionRepoImp
import com.halim.humtask.di.scope.AppScope
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.repository.QuestionRepo
import dagger.Module
import dagger.Provides


@Module(includes = [DataSetModule::class])
class RepoModule {

    @AppScope
    @Provides
    fun provideQuestionRepo(dataSet: QuestionsDataSet): QuestionRepo =
        QuestionRepoImp(dataSet)

    @AppScope
    @Provides
    fun provideAnswerRepo(dataSet: AnswersDataSet): AnswerRepo =
        AnswerRepoImp(dataSet)
}