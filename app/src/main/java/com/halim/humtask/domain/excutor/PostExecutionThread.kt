package com.halim.humtask.domain.excutor

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}
