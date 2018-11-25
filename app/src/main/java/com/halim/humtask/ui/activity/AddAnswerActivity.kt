package com.halim.humtask.ui.activity

import com.halim.humtask.R
import com.halim.humtask.domain.presenter.AddAnswerPresenter
import kotlinx.android.synthetic.main.activiy_add_question.*


class AddAnswerActivity : BaseActivity<AddAnswerPresenter>() {

    companion object {
        const val PARENT_ELEMENT = "parent_element"
    }

    override fun getLayoutId(): Int =
        R.layout.activiy_add_answer

    override fun onViewCreated(presenter: AddAnswerPresenter) {
        saveBtn.setOnClickListener {
            presenter.addAnswer(
                descEdit.text.toString()
            )
        }
    }

    override fun showHomeAsUp(): Boolean =
        true

    override fun getActivityTitle(): String? =
        getString(R.string.add_answer)
}