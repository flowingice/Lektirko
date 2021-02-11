package hr.tvz.mmisic.lektirko.ui.book

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import kotlinx.android.synthetic.main.add_book_layout.book_author
import kotlinx.android.synthetic.main.add_book_layout.book_title
import kotlinx.android.synthetic.main.add_book_layout.btn_cancel
import kotlinx.android.synthetic.main.add_book_layout.btn_save


class AddBookDialog(context: Context, var addBookListener: AddBookListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_book_layout)

        btn_save.setOnClickListener{
            val title = book_title.text.toString()
            val author = book_author.text.toString()

            if (title.isEmpty() || author.isEmpty()){
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            addBookListener.onAddButtonClicked(BookItem(title, author))
            dismiss()
        }

        btn_cancel.setOnClickListener {
            cancel()
        }
    }



}
