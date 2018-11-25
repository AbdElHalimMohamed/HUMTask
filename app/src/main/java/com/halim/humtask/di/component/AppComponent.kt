package com.halim.humtask.di.component

import com.halim.humtask.App
import com.halim.humtask.di.module.app.ActivitiesModule
import com.halim.humtask.di.module.app.AppModule
import com.halim.humtask.di.module.app.RepoModule
import com.halim.humtask.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjector


@AppScope
@Component(modules = [AppModule::class, RepoModule::class, ActivitiesModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}