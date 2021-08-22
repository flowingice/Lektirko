package hr.tvz.mmisic.lektirko.ui.question

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.User
import hr.tvz.mmisic.lektirko.data.db.entities.relations.BookItem_BookQuestion
import kotlinx.android.synthetic.main.confirm_send_answer_email_layout.btn_send
import kotlinx.android.synthetic.main.save_answer_email_layout.btn_cancel

class ConfirmSendAnswerEmailDialog(
    context: Context,
    private val bookData: List<BookItem_BookQuestion>?,
    private val allUsers: List<User>
) :
    AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_send_answer_email_layout)
        if (bookData == null) {
            Toast.makeText(context, "Podaci o knjizi nisu dostupni", Toast.LENGTH_SHORT).show()
            dismiss()
            return
        }


        btn_send.setOnClickListener {
            val savedEmail =
                context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
                    .getString("answerEmail", "")

            if (savedEmail.equals("")) {
                val dialog = SaveAnswerEmailDialog(context)
                dialog.show()
                dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            } else {
                val emailIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(savedEmail))
                    putExtra(
                        Intent.EXTRA_SUBJECT,
                        bookToSubject(
                            bookData[0].book.bookTitle,
                            allUsers.joinToString { it.shortData() })
                    )
                    putExtra(Intent.EXTRA_TEXT, bookDataToString(bookData[0], allUsers.joinToString { it.allData() }))
                }

                if (emailIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(emailIntent);
                }
            }


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
