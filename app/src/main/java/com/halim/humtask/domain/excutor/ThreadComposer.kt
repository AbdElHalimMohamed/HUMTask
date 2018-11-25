package com.halim.humtask.domain.excutor

import io.reactivex.FlowableTransformer
import io.reactivex.schedulers.Schedulers


class ThreadComposer(
    private val threadExecutor: ThreadExecutor,
    private val uiExecutor: PostExecutionThread
) {

    fun <T> applyFlowableThread(): FlowableTransformer<T, T> =
        FlowableTransformer {
            it.subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(uiExecutor.scheduler)
        }
}