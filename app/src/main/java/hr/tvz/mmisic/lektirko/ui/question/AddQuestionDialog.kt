package hr.tvz.mmisic.lektirko.ui.question

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion
import kotlinx.android.synthetic.main.add_question_layout.btn_cancel
import kotlinx.android.synthetic.main.add_question_layout.btn_save
import kotlinx.android.synthetic.main.add_question_layout.question

class AddQuestionDialog(context: Context, var bookId:Int, var addQuestionListener: AddQuestionListener): AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_question_layout)

        btn_save.setOnClickListener {
            val question = question.text.toString()

            if (question.isEmpty()){
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            addQuestionListener.onAddButtonClicked(BookQuestion(question, null, bookId))
            dismiss()
        }

        btn_cancel.setOnClickListener {
            cancel()
        }

    }
}
