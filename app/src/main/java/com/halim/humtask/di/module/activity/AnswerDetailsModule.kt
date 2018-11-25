package com.halim.humtask.di.module.activity

import com.halim.humtask.di.scope.ActivityScope
import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.presenter.AnswerDetailsPresenter
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.usecase.answer.GetAnswerUseCase
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.view.AnswerDetailsView
import com.halim.humtask.ui.activity.AnswerDetailsActivity
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [AnswerDetailsModule.Bind::class])
class AnswerDetailsModule {

    @Provides
    @ActivityScope
    fun provideAnswer(activity: AnswerDetailsActivity): Answer =
        activity.intent.extras.getParcelable(AnswerDetailsActivity.ANSWER)

    @Provides
    @ActivityScope
    fun provideListAllAnswersUseCase(repo: AnswerRepo, threadComposer: ThreadComposer) =
        ListAllAnswersUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun provideGetAnswersUseCase(repo: AnswerRepo, threadComposer: ThreadComposer) =
        GetAnswerUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun providePresenter(
        view: AnswerDetailsView,
        listAllAnswersUseCase: ListAllAnswersUseCase,
        getAnswerUseCase: GetAnswerUseCase,
        answer: Answer
    ): AnswerDetailsPresenter =
        AnswerDetailsPresenter(
            view, listAllAnswersUseCase,
            getAnswerUseCase, answer
        )

    @Module
    abstract class Bind {
        @Binds
        @ActivityScope
        abstract fun bindView(activity: AnswerDetailsActivity): AnswerDetailsView
    }
}