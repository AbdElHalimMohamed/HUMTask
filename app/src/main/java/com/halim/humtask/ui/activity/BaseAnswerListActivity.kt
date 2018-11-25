package com.halim.humtask.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.halim.humtask.R
import com.halim.humtask.domain.entity.Answer
import com.halim.humtask.domain.presenter.BaseAnswerListPresenter
import com.halim.humtask.domain.view.AnswerListView
import com.halim.humtask.ui.adapter.AnswerAdapter
import com.halim.humtask.ui.adapter.decorator.SpacesItemDecoration
import com.halim.humtask.ui.startActivity


abstract class BaseAnswerListActivity<P : BaseAnswerListPresenter<*>>
    : BaseActivity<P>(), AnswerListView {

    private var answersRV: RecyclerView? = null

    override fun showAnswers(answers: List<Answer>) {
        (answersRV?.adapter as? AnswerAdapter)?.setItems(answers)
    }

    override fun openAnswerDetails(answer: Answer) {
        startActivity(AnswerDetailsActivity::class,
            AnswerDetailsActivity.ANSWER, answer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.activity_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        when (item?.itemId) {
            R.id.action_add -> {
                presenter.addAnswer()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    protected fun setUpAnswersAdapter(rv: RecyclerView) {
        this.answersRV = rv

        rv.adapter = AnswerAdapter {
            presenter.showAnswerDetails(it)
        }
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(SpacesItemDecoration(8, this))
    }
}