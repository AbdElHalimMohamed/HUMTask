package com.halim.humtask.di.module.activity

import android.os.Parcelable
import com.halim.humtask.di.scope.ActivityScope
import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.entity.ElementType
import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.excutor.ThreadComposer
import com.halim.humtask.domain.presenter.AddAnswerPresenter
import com.halim.humtask.domain.repository.AnswerRepo
import com.halim.humtask.domain.usecase.answer.AddAnswerUseCase
import com.halim.humtask.domain.view.View
import com.halim.humtask.ui.activity.AddAnswerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [AddAnswerModule.Bind::class])
class AddAnswerModule {

    @Provides
    @ActivityScope
    fun provideAddAnswerUseCaseUseCase(repo: AnswerRepo, threadComposer: ThreadComposer) =
        AddAnswerUseCase(repo, threadComposer)

    @Provides
    @ActivityScope
    fun providePresenter(
        view: View,
        addAnswerUseCase: AddAnswerUseCase,
        parent: ParentWrapper
    ): AddAnswerPresenter =
        AddAnswerPresenter(
            view, addAnswerUseCase,
            parent.id,
            parent.type
        )

    @Provides
    @ActivityScope
    fun provideParentWrapper(activity: AddAnswerActivity): ParentWrapper {
        val element = activity.intent.getParcelableExtra<Parcelable>(AddAnswerActivity.PARENT_ELEMENT)
        return when (element) {
            is Question -> ParentWrapper(element.id, ElementType.Question)
            is Answer -> ParentWrapper(element.id, ElementType.Answer)
            else -> ParentWrapper()
        }
    }

    @Module
    abstract class Bind {
        @Binds
        @ActivityScope
        abstract fun bindView(activity: AddAnswerActivity): View
    }

    data class ParentWrapper(
        val id: Long = -1,
        val type: ElementType = ElementType.Question
    )
}