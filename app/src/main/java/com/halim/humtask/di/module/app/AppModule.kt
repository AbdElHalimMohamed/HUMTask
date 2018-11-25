package com.halim.humtask.di.module.app

import android.app.Application
import android.content.Context
import com.halim.humtask.App
import com.halim.humtask.di.qualifier.AppQualifier
import com.halim.humtask.di.scope.AppScope
import com.halim.humtask.domain.excutor.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@Module(includes = [(AndroidInjectionModule::class), (AppModule.Bind::class)])
class AppModule {

    @Provides
    @AppScope
    fun provideThreadComposer(threadExecutor: ThreadExecutor,
                              uiExecutor: PostExecutionThread) =
        ThreadComposer(threadExecutor, uiExecutor)

    @Module
    abstract class Bind {

        @Binds
        @AppScope
        abstract fun bindApp(app: App): Application

        @Binds
        @AppScope
        @AppQualifier
        abstract fun bindAppContext(context: App): Context

        @Binds
        @AppScope
        abstract fun bindThreadExecutor(threadPoolExecutor: ThreadPoolExecutor): ThreadExecutor

        @Binds
        @AppScope
        abstract fun bindUIExecutor(uiExecutor: UIExecutor): PostExecutionThread
    }
}