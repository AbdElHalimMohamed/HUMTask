package com.halim.humtask.domain.presenter

import com.halim.humtask.domain.usecase.UseCase
import com.halim.humtask.domain.value
import com.halim.humtask.domain.view.View
import java.lang.ref.WeakReference


abstract class Presenter<V : View>(
    view: V,
    private val useCases: List<UseCase<*, *>> = arrayListOf()
) {

    private val viewReference = WeakReference<V>(view)
    protected val view: V?
        get() = viewReference.value


    fun dispose() {
        useCases.forEach {
            it.dispose()
        }
    }
}