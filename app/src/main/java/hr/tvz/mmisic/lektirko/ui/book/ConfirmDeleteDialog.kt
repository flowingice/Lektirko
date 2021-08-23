package hr.tvz.mmisic.lektirko.ui.book

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.ViewModel
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.User
import hr.tvz.mmisic.lektirko.data.db.entities.relations.BookItem_BookQuestion
import hr.tvz.mmisic.lektirko.ui.question.SaveAnswerEmailDialog
import kotlinx.android.synthetic.main.confirm_delete_layout.btn_delete
import kotlinx.android.synthetic.main.confirm_send_answer_email_layout.btn_send
import kotlinx.android.synthetic.main.save_answer_email_layout.btn_cancel

class ConfirmDeleteDialog(
    context: Context,
    val viewModel: BookViewModel,
    val book: BookItem

) :
    AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_delete_layout)


        btn_delete.setOnClickListener {
            viewModel.delete(book)
            dismiss()
        }

        btn_cancel.setOnClickListener {
            cancel()
        }

    }


    private fun bookToSubject(bookTitle: String, user: String): String {


        return "$user predaja knjige $bookTitle"

    }

    private fun bookDataToString(bookData: BookItem_BookQuestion, user: String): String {
        var data = bookToSubject(bookData.book.bookTitle, user) + "\n\n"
        bookData.questions.forEach { e ->
            run {
                data += e.question
                data += "\n"
                if (e.answer.isNullOrBlank()) {
                    data += "Nije odgovoreno"
                } else {
                    data += e.answer
                }
                data += "\n\n"
            }
        }
        return data;
    }
}
