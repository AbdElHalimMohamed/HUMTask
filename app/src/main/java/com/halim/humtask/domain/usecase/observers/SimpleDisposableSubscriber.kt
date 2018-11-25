package com.halim.humtask.domain.usecase.observers

import com.halim.humtask.domain.value
import com.halim.humtask.domain.view.View
import io.reactivex.subscribers.DisposableSubscriber
import java.lang.ref.WeakReference


open class SimpleDisposableSubscriber<T>(view: View?) :
    DisposableSubscriber<T>() {

    private val baseView = WeakReference<View>(view)

    override fun onStart() {
        super.onStart()
        baseView.value?.showLoadingDataProgress()
    }

    override fun onComplete() {
    }

    override fun onNext(data: T) {
        baseView.value?.hideLoadingDataProgress()
    }

    override fun onError(e: Throwable) {
        // TODO parse the exception
        baseView.value?.showErrorMsg()
    }
}