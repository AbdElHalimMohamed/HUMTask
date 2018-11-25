package com.halim.humtask.di.module.activity

import com.halim.humtask.di.scope.ActivityScope
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.presenter.AddQuestionPresenter
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.question.AddQuestionUseCase
import com.halim.humtask.domain.view.View
import com.halim.humtask.ui.activity.AddQuestionActivity
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [AddQuestionModule.Bind::class])
class AddQuestionModule {

    @Provides
    @ActivityScope
    fun provideListAllQuestionsUseCase(repo: QuestionRepo, threadComposer: ThreadComposer) =
        AddQuestionUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun providePresenter(
        view: View,
        addQuestionsUseCase: AddQuestionUseCase
    ): AddQuestionPresenter =
        AddQuestionPresenter(view, addQuestionsUseCase)

    @Module
    abstract class Bind {
        @Binds
        @ActivityScope
        abstract fun bindView(activity: AddQuestionActivity): View
    }
}