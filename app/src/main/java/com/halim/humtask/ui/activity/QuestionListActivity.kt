package com.halim.humtask.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.halim.humtask.R
import com.halim.humtask.domain.entity.Question
import com.halim.humtask.domain.presenter.QuestionListPresenter
import com.halim.humtask.domain.view.QuestionListView
import com.halim.humtask.ui.adapter.QuestionAdapter
import com.halim.humtask.ui.adapter.decorator.SpacesItemDecoration
import com.halim.humtask.ui.startActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_list_question.*


class QuestionListActivity : BaseActivity<QuestionListPresenter>(), QuestionListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int =
        R.layout.activity_list_question

    override fun onViewCreated(presenter: QuestionListPresenter) {

        questionsRV.adapter = QuestionAdapter {
            presenter.showDetails(it)
        }
        questionsRV.layoutManager = LinearLayoutManager(this)
        questionsRV.addItemDecoration(SpacesItemDecoration(8, this))

        presenter.loadQuestions()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.activity_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        when (item?.itemId) {
            R.id.action_add -> {
                startActivity(AddQuestionActivity::class)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun showQuestions(questions: List<Question>) {
        (questionsRV.adapter as? QuestionAdapter)?.setItems(questions)
        hideEmptyResult()
    }

    override fun showQuestionDetails(question: Question) {
        startActivity(
            QuestionDetailsActivity::class,
            QuestionDetailsActivity.QUESTION, question
        )
    }
}