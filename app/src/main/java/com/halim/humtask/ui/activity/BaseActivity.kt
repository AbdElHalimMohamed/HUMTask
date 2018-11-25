package com.halim.humtask.ui.activity

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import com.halim.humtask.R
import com.halim.humtask.domain.presenter.Presenter
import com.halim.humtask.domain.view.View
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject


abstract class BaseActivity<P : Presenter<*>> : AppCompatActivity(), View {

    @Inject
    open lateinit var presenter: P

    abstract fun getLayoutId(): Int
    abstract fun onViewCreated(presenter: P)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)

        AndroidInjection.inject(this)

        val layoutId = getLayoutId()

        if (layoutId > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                content.isTransitionGroup = true
            }
            content.addView(
                LayoutInflater.from(this).inflate(layoutId, null), FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            )
        }

        if (showHomeAsUp()) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        }

        onViewCreated(presenter)

        val title = getActivityTitle()
        if (title != null) {
            this.title = title
        }
    }

    open fun getActivityTitle(): String? = null

    open fun showHomeAsUp() = false

    override fun showLoadingDataProgress() {
        showLoader()
    }

    override fun hideLoadingDataProgress() {
        fullScreenLoader.visibility = INVISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem?) =
        when (item?.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                true
            }
            else -> {
                false
            }
        }

    override fun showEmptyResult() {
        showEmptyView()
    }

    override fun showErrorMsg() {
        showErrorView()
    }

    private fun showErrorView() {
        errorView.visibility = VISIBLE
        emptyView.visibility = INVISIBLE
    }

    private fun showEmptyView() {
        errorView.visibility = INVISIBLE
        emptyView.visibility = VISIBLE
    }

    private fun showLoader() {
        fullScreenLoader.visibility = VISIBLE
        errorView.visibility = INVISIBLE
        emptyView.visibility = INVISIBLE
    }

    override fun close() {
        supportFinishAfterTransition()
    }

    override fun onDestroy() {
        presenter.dispose()
        super.onDestroy()
    }
}