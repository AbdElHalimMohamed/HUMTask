package com.halim.humtask.ui.activity

import com.halim.humtask.R
import com.halim.humtask.domain.presenter.AddQuestionPresenter
import kotlinx.android.synthetic.main.activiy_add_question.*


class AddQuestionActivity : BaseActivity<AddQuestionPresenter>() {

    override fun getLayoutId(): Int =
        R.layout.activiy_add_question

    override fun onViewCreated(presenter: AddQuestionPresenter) {
        saveBtn.setOnClickListener {
            presenter.addQuestion(
                titleEdit.text.toString(),
                descEdit.text.toString()
            )
        }
    }

    override fun showHomeAsUp(): Boolean =
        true

    override fun getActivityTitle(): String? =
        getString(R.string.add_question)
}