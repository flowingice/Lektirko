package hr.tvz.mmisic.lektirko.ui.question

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import hr.tvz.mmisic.lektirko.R
import kotlinx.android.synthetic.main.save_answer_email_layout.btn_cancel
import kotlinx.android.synthetic.main.save_answer_email_layout.btn_save
import kotlinx.android.synthetic.main.save_answer_email_layout.email

class SaveAnswerEmailDialog(context: Context, ): AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_question_layout)

        val savedEmail = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            .getString("answerEmail", "")

        email.setText(savedEmail)

        btn_save.setOnClickListener {
            val pref =
                context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE).edit()
            pref.putString("answerEmail", email.text.toString())
            pref.apply()
        }

        btn_cancel.setOnClickListener {
            cancel()
        }

    }
}
