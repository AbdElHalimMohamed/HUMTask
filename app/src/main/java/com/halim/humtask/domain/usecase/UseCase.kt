package com.halim.humtask.domain.usecase

import com.halim.humtask.domain.excutor.ThreadComposer
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber


abstract class UseCase<T, in Params>(
    private val threadComposer: ThreadComposer
) {

    private var disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params): Flowable<T>

    fun execute(params: Params, subscriber: DisposableSubscriber<T>) {
        if (disposables.isDisposed) {
            disposables = CompositeDisposable()
        }

        disposables.add(
            buildUseCaseObservable(params)
                .compose(threadComposer.applyFlowableThread())
                .subscribeWith(subscriber)
        )
    }

    fun dispose() {
        disposables.dispose()
    }
}