package hr.tvz.mmisic.lektirko.ui.book

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.tvz.mmisic.lektirko.BookQuestionsActivity
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import kotlinx.android.synthetic.main.adapter_book_list_layout.view.author
import kotlinx.android.synthetic.main.adapter_book_list_layout.view.book_adapter_layout
import kotlinx.android.synthetic.main.adapter_book_list_layout.view.book_title


class BookAdapter(
    var items: List<BookItem>,
    private val viewModel: BookViewModel
) : RecyclerView.Adapter<BookAdapter.BookItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_book_list_layout, parent, false)
        return BookItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val currBook = items[position]

        holder.itemView.book_title.text = currBook.bookTitle
        holder.itemView.author.text = currBook.bookAuthor

        holder.itemView.book_adapter_layout.setOnClickListener {
            val intent = Intent(it.context, BookQuestionsActivity::class.java).apply {
                putExtra("TITLE", currBook.bookTitle)
                putExtra("AUTHOR", currBook.bookAuthor)
                putExtra("ID", currBook.id)
            }

            it.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BookItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
