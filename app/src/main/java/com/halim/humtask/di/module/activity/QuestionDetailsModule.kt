package com.halim.humtask.di.module.activity

import com.halim.humtask.di.scope.ActivityScope
import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.presenter.QuestionDetailsPresenter
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.repository.QuestionRepo
import com.halim.humtask.domain.usecase.answer.ListAllAnswersUseCase
import com.halim.humtask.domain.usecase.question.GetQuestionUseCase
import com.halim.humtask.domain.view.QuestionDetailsView
import com.halim.humtask.ui.activity.QuestionDetailsActivity
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [QuestionDetailsModule.Bind::class])
class QuestionDetailsModule {

    @Provides
    @ActivityScope
    fun provideQuestion(activity: QuestionDetailsActivity): Question =
        activity.intent.extras.getParcelable(QuestionDetailsActivity.QUESTION)

    @Provides
    @ActivityScope
    fun provideListAllQuestionsUseCase(repo: AnswerRepo, threadComposer: ThreadComposer) =
        ListAllAnswersUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun provideGetQuestionsUseCase(repo: QuestionRepo, threadComposer: ThreadComposer) =
        GetQuestionUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun providePresenter(
        view: QuestionDetailsView,
        listAllAnswersUseCase: ListAllAnswersUseCase,
        getQuestionUseCase: GetQuestionUseCase,
        question: Question
    ): QuestionDetailsPresenter =
        QuestionDetailsPresenter(
            view, listAllAnswersUseCase,
            getQuestionUseCase, question
        )

    @Module
    abstract class Bind {
        @Binds
        @ActivityScope
        abstract fun bindView(activity: QuestionDetailsActivity): QuestionDetailsView
    }
}