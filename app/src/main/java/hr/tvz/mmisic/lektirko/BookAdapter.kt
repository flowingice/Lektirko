package hr.tvz.mmisic.lektirko

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BookAdapter(
    private val context: Context,
    private val dataSource: ArrayList<BookItem>
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
        //val rowView = inflater.inflate(R.layout.adapter_book_list_layout, parent, false)
        val rowView = convertView ?: inflater.inflate(R.layout.adapter_book_list_layout, parent, false)

        val bookAuthorField = rowView.findViewById(R.id.author) as TextView
        val bookTitleField = rowView.findViewById(R.id.book_title) as TextView
        val bookHoursField = rowView.findViewById(R.id.hoursRead) as TextView
        val bookQuestionsField = rowView.findViewById(R.id.questionsAnswered) as TextView

        val currentBook = getItem(position) as BookItem
        bookAuthorField.text = currentBook.bookAuthor
        bookTitleField.text = currentBook.bookTitle
        bookHoursField.text = currentBook.hoursRead
        bookQuestionsField.text = currentBook.questionsAnswered


        return rowView
    }
}
