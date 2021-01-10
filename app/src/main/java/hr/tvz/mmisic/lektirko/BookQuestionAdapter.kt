package hr.tvz.mmisic.lektirko

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BookQuestionAdapter(
    private val context: Context,
    private val dataSource: ArrayList<ListItem>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.adapter_book_list_layout, parent, false)

        val question = rowView.findViewById(R.id.question) as TextView
        val isAnswered = rowView.findViewById(R.id.isAnswered) as TextView

        val currentQuestion = getItem(position) as BookQuestion
        question.text = currentQuestion.question
        isAnswered.text = if (currentQuestion.isAnswered) {
            isAnswered.setTextColor(Color.GREEN)
            R.string.answered.toString()
        } else {
            isAnswered.setTextColor(Color.RED)
            R.string.not_answered.toString()
        }

        return rowView
    }

}
