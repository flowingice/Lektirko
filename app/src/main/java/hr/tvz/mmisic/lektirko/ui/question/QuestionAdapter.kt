package hr.tvz.mmisic.lektirko.ui.question

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion
import kotlinx.android.synthetic.main.adapter_book_question_layout.view.isAnswered
import kotlinx.android.synthetic.main.adapter_book_question_layout.view.question
import kotlinx.android.synthetic.main.adapter_book_question_layout.view.question_adapter_layout

class QuestionAdapter(
    var items: List<BookQuestion>,
    private val viewModel: QuestionViewModel,
    var context: Context
) : RecyclerView.Adapter<QuestionAdapter.QuestionItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_book_question_layout, parent, false)
        return QuestionItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionItemViewHolder, position: Int) {
        val currQuestion = items[position]

        holder.itemView.question.text = currQuestion.question
        holder.itemView.isAnswered.text = if (currQuestion.answer.isNullOrEmpty()) {

            holder.itemView.isAnswered.setTextColor(Color.RED)
            context.getString(R.string.not_answered)
        } else {
            holder.itemView.isAnswered.setTextColor(Color.GREEN)
            context.getString(R.string.answered)
        }

        holder.itemView.question_adapter_layout.setOnClickListener {
            val intent = Intent(it.context, AnswerActivity::class.java).apply {
                putExtra("ID", currQuestion.id)
            }
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class QuestionItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
