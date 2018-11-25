package com.halim.humtask.domain.view

interface View {

    // Data that will fill the view
    fun showLoadingDataProgress() {}

    fun hideLoadingDataProgress() {}

    fun showEmptyResult() {}

    fun hideEmptyResult() {}

    fun showMsg(msg: String) {}

    fun showErrorMsg() {}

    fun close() {}
}