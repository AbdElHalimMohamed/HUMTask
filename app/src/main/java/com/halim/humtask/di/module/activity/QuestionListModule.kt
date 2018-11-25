package com.halim.humtask.di.module.activity

import com.halim.humtask.di.scope.ActivityScope
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.presenter.QuestionListPresenter
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.question.ListAllQuestionsUseCase
import com.halim.humtask.domain.view.QuestionListView
import com.halim.humtask.ui.activity.QuestionListActivity
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [QuestionListModule.Bind::class])
class QuestionListModule {

    @Provides
    @ActivityScope
    fun provideListAllQuestionsUseCase(repo: QuestionRepo, threadComposer: ThreadComposer) =
        ListAllQuestionsUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun providePresenter(view: QuestionListView,
                         listAllQuestionsUseCase: ListAllQuestionsUseCase): QuestionListPresenter =
        QuestionListPresenter(view, listAllQuestionsUseCase)

    @Module
    abstract class Bind {
        @Binds
        @ActivityScope
        abstract fun bindView(activity: QuestionListActivity): QuestionListView
    }
}