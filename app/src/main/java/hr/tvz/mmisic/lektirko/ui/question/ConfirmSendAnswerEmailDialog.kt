package hr.tvz.mmisic.lektirko.ui.question

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.relations.BookItem_BookQuestion
import kotlinx.android.synthetic.main.confirm_send_answer_email_layout.btn_send
import kotlinx.android.synthetic.main.save_answer_email_layout.btn_cancel

class ConfirmSendAnswerEmailDialog(context: Context, val bookData: List<BookItem_BookQuestion>?) :
    AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_question_layout)


        btn_send.setOnClickListener {
            val savedEmail =
                context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
                    .getString("answerEmail", "")


        }

        btn_cancel.setOnClickListener {
            cancel()
        }

    }

    fun bookDataToString(bookData: BookItem_BookQuestion): String {
        var data = "";
        bookData.questions.forEach { e ->
            run {
                data += e.question
                data += "\n"
                if (e.answer.isNullOrBlank()) {
                    data += "Nije odgovoreno"
                } else {
                    data += e.answer
                }
                data += "\n"
            }
        }
        return data;
    }
}
