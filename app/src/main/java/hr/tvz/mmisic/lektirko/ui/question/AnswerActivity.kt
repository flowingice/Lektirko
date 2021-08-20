package hr.tvz.mmisic.lektirko.ui.question

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.ui.settings.font.FontUtil
import kotlinx.android.synthetic.main.activity_question_answer_layout.answer
import kotlinx.android.synthetic.main.activity_question_answer_layout.btn_cancel
import kotlinx.android.synthetic.main.activity_question_answer_layout.btn_save
import kotlinx.android.synthetic.main.activity_question_answer_layout.question
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class AnswerActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val factory: QuestionViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FontUtil.updateTheme(this)
        setContentView(R.layout.activity_question_answer_layout)

        val id: Int = intent.getIntExtra("ID", -1)

        if (id == -1) {
            Toast.makeText(this, this.getString(R.string.error), Toast.LENGTH_SHORT).show()
            super.finish()
        }

        val viewModel = ViewModelProvider(this, factory).get(QuestionViewModel::class.java)

        viewModel.getAllQuestions().observe(this) {
            val currentQuestion = it.find { e -> e.id == id }
            if (currentQuestion != null) {
                question.text = currentQuestion.question
                answer.setText(currentQuestion.answer)

                btn_save.setOnClickListener {
                    currentQuestion.answer = answer.text.toString()
                    viewModel.upsert(currentQuestion)
                    super.finish()
                }

                btn_cancel.setOnClickListener {
                    super.finish()
                }
            }

        }

    }

}
