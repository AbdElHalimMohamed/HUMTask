package com.halim.humtask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halim.humtask.R
import com.halim.humtask.domain.entity.Answer
import kotlinx.android.synthetic.main.adapter_answer_item.view.*


class AnswerAdapter(
    questions: List<Answer> = listOf(),
    private val onClickAnswer: (Answer) -> Unit
) :
    BaseRecyclerAdapter<Answer, AnswerAdapter.AnswerVH>(questions) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerVH =
        AnswerVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_answer_item, parent, false)
        )


    inner class AnswerVH(view: View) : BaseViewHolder<Answer>(view) {
        override fun bind(model: Answer) {
            itemView?.tag = model
            itemView?.descTV?.text = model.description
            itemView?.numOfAnswersTV?.text = "${model.numOfSubAnswers}"

            itemView?.setOnClickListener {
                (it.tag as? Answer)?.let(onClickAnswer)
            }
        }
    }
}