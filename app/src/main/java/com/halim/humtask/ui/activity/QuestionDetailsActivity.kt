package com.halim.humtask.ui.activity

import android.os.Bundle
import com.halim.humtask.R
import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.presenter.QuestionDetailsPresenter
import com.halim.humtask.domain.view.QuestionDetailsView
import com.halim.humtask.ui.startActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_questoin_details.*


class QuestionDetailsActivity : BaseAnswerListActivity<QuestionDetailsPresenter>(),
    QuestionDetailsView {

    companion object {
        const val QUESTION = "question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int =
        R.layout.activity_questoin_details

    override fun onViewCreated(presenter: QuestionDetailsPresenter) {

        setUpAnswersAdapter(answersRV)

        presenter.getQuestionDetails()
    }

    override fun showQuestion(question: Question) {
        questionTitleTV.text = question.title
        questionDescTV.text = question.description
        numOfAnswersTV.text = "${question.numOfAnswers}"
    }

    override fun openAddAnswer(question: Question) {
        startActivity(
            AddAnswerActivity::class,
            AddAnswerActivity.PARENT_ELEMENT, question
        )
    }

    override fun showHomeAsUp(): Boolean =
        true

    override fun getActivityTitle(): String? =
        getString(R.string.question_details)
}