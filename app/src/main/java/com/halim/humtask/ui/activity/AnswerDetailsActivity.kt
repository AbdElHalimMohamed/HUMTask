package com.halim.humtask.ui.activity

import android.os.Bundle
import com.halim.humtask.R
import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.presenter.AnswerDetailsPresenter
import com.halim.humtask.domain.view.AnswerDetailsView
import com.halim.humtask.ui.startActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_answer_details.*


class AnswerDetailsActivity : BaseAnswerListActivity<AnswerDetailsPresenter>(),
    AnswerDetailsView {

    companion object {
        const val ANSWER = "answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int =
        R.layout.activity_answer_details

    override fun onViewCreated(presenter: AnswerDetailsPresenter) {

        setUpAnswersAdapter(answersRV)

        presenter.getAnswerDetails()
    }

    override fun showAnswer(answer: Answer) {
        answerDescTV.text = answer.description
        numOfAnswersTV.text = "${answer.numOfSubAnswers}"
    }

    override fun openAddAnswer(answer: Answer) {
        startActivity(
            AddAnswerActivity::class,
            AddAnswerActivity.PARENT_ELEMENT, answer
        )
    }

    override fun showHomeAsUp(): Boolean =
        true

    override fun getActivityTitle(): String? =
        getString(R.string.answer_details)
}