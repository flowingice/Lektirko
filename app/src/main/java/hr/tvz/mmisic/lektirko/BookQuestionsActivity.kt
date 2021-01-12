package hr.tvz.mmisic.lektirko

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_book_questions.*

class BookQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_questions)

        val listView: ListView = findViewById(R.id.listView)

        val questions: ArrayList<BookQuestion> = ArrayList()
        questions.add(BookQuestion(1, "Question", "Answer1"))
        questions.add(BookQuestion(12, "Question2", "Answer2"))
        questions.add(BookQuestion(13, "Question3", ""))
        questions.add(BookQuestion(14, "Question4", "not null"))
        questions.add(BookQuestion(15, "Question5", "Answer5"))

        val adapter = BookQuestionAdapter(this, questions)
        listView.adapter = adapter


        book_title.text = intent.getStringExtra("TITLE")
        author.text = intent.getStringExtra("AUTHOR")

    }

    fun showQuestions(view: View) {
        val intent = Intent(this, BookReadingLogActivity::class.java).apply {
            putExtra("TITLE", intent.getStringExtra("TITLE"))
            putExtra("AUTHOR", intent.getStringExtra("AUTHOR"))
        }
        startActivity(intent)
    }
}
