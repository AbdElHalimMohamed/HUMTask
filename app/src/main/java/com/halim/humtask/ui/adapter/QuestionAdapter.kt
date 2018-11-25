package com.halim.humtask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halim.humtask.R
import com.halim.humtask.domain.entity.Question
import kotlinx.android.synthetic.main.adapter_question_item.view.*


class QuestionAdapter(
    questions: List<Question> = listOf(),
    private val onQuestionClick: (Question) -> Unit
) :
    BaseRecyclerAdapter<Question, QuestionAdapter.QuestionVH>(questions) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionVH =
        QuestionVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_question_item, parent, false)
        )

    inner class QuestionVH(view: View) : BaseViewHolder<Question>(view) {

        override fun bind(model: Question) {
            itemView?.tag = model
            itemView?.titleTV?.text = model.title
            itemView?.descTV?.text = model.description
            itemView?.numOfAnswersTV?.text = "${model.numOfAnswers}"

            itemView?.setOnClickListener {
                (it.tag as? Question)?.let(onQuestionClick)
            }
        }
    }
}