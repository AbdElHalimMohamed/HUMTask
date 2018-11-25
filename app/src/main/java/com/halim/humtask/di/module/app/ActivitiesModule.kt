package com.halim.humtask.di.module.app

import com.halim.humtask.di.module.activity.*
import com.halim.humtask.di.scope.ActivityScope
import com.halim.humtask.ui.activity.*
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [QuestionListModule::class])
    abstract fun listQuestionsActivityInjector(): QuestionListActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AddQuestionModule::class])
    abstract fun addQuestionActivityInjector(): AddQuestionActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AddAnswerModule::class])
    abstract fun addAnswerActivityInjector(): AddAnswerActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [QuestionDetailsModule::class])
    abstract fun questionDetailsActivityInjector(): QuestionDetailsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AnswerDetailsModule::class])
    abstract fun answerDetailsActivityInjector(): AnswerDetailsActivity
}