package hr.tvz.mmisic.lektirko.ui.question

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion
import hr.tvz.mmisic.lektirko.ui.book_question.BookQuestionViewModel
import hr.tvz.mmisic.lektirko.ui.book_question.BookQuestionViewModelFactory
import hr.tvz.mmisic.lektirko.ui.login.UserViewModel
import hr.tvz.mmisic.lektirko.ui.login.UserViewModelFactory
import hr.tvz.mmisic.lektirko.ui.settings.font.FontUtil
import kotlinx.android.synthetic.main.activity_book_questions.add_new_question
import kotlinx.android.synthetic.main.activity_book_questions.author
import kotlinx.android.synthetic.main.activity_book_questions.book_title
import kotlinx.android.synthetic.main.activity_book_questions.rvBookQuestionItems
import kotlinx.android.synthetic.main.activity_book_questions.send_answers
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class QuestionActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val factory: QuestionViewModelFactory by instance()
    private val bookQuestionFactory: BookQuestionViewModelFactory by instance()
    private val userFactory: UserViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FontUtil.updateTheme(this)
        setContentView(R.layout.activity_book_questions)



        val viewModel = ViewModelProvider(this, factory).get(QuestionViewModel::class.java)
        val userViewModel = ViewModelProvider(this, userFactory).get(UserViewModel::class.java)


        val bQviewModel = ViewModelProvider(this, bookQuestionFactory).get(BookQuestionViewModel::class.java)

        val adapter = QuestionAdapter(listOf(), viewModel, this.applicationContext)

        rvBookQuestionItems.layoutManager = LinearLayoutManager(this)
        rvBookQuestionItems.adapter = adapter



        book_title.text = intent.getStringExtra("TITLE")
        author.text = intent.getStringExtra("AUTHOR")
        val id: Int = intent.getIntExtra("ID", -1)

        bQviewModel.getByBookId(id).observe(this) {
            adapter.items = it[0].questions
            adapter.notifyDataSetChanged()
        }

        add_new_question.setOnClickListener {
            val dialog = AddQuestionDialog(this,id, object :AddQuestionListener{
                override fun onAddButtonClicked(item: BookQuestion) {
                    viewModel.upsert(item)
                }
            })
            dialog.show()
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        send_answers.setOnClickListener {
            bQviewModel.getByBookId(id).observe(this) {books ->
                userViewModel.getAllUsers().observe(this) { users ->
                    val dialog = ConfirmSendAnswerEmailDialog(this, books, users)
                    dialog.show()
                    dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                }
            }


        }




    }

}
