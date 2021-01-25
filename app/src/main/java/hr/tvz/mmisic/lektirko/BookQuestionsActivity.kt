package hr.tvz.mmisic.lektirko

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion
import kotlinx.android.synthetic.main.activity_book_questions.*

class BookQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_questions)

        val listView: ListView = findViewById(R.id.listView)

        val questions: ArrayList<BookQuestion> = ArrayList()
        questions.add(BookQuestion("Question", "Answer1"))
        questions.add(BookQuestion("Question2", "Answer2"))
        questions.add(BookQuestion("Question3", ""))
        questions.add(BookQuestion("Question4", "not null"))
        questions.add(BookQuestion("Question5", "Answer5"))

        val adapter = BookQuestionAdapter(this, questions)
        listView.adapter = adapter


        book_title.text = intent.getStringExtra("TITLE")
        author.text = intent.getStringExtra("AUTHOR")

    }

}
