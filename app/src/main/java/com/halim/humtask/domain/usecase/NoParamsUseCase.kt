package com.halim.humtask.domain.usecase

import com.halim.humtask.domain.excutor.ThreadComposer
import io.reactivex.Flowable
import io.reactivex.subscribers.DisposableSubscriber


abstract class NoParamsUseCase<T>(threadComposer: ThreadComposer) : UseCase<T, Nothing?>(threadComposer) {

    override fun buildUseCaseObservable(params: Nothing?): Flowable<T> =
        buildUseCaseObservable()

    abstract fun buildUseCaseObservable(): Flowable<T>

    fun execute(subscriber: DisposableSubscriber<T>) {
        super.execute(null, subscriber)
    }
}