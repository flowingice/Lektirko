package hr.tvz.mmisic.lektirko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_book_questions.*
import java.time.LocalDate

class BookReadingLogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_reading_log)


        val listView: ListView = findViewById(R.id.listView)

        val logs: ArrayList<LogItem> = ArrayList()
        logs.add(LogItem(1, LocalDate.now(), 0.5f, 1))
        logs.add(LogItem(12, LocalDate.now(), 12f, 12))
        logs.add(LogItem(13, LocalDate.now(), 13f, 13))
        logs.add(LogItem(14, LocalDate.now(), 14f, 14))
        logs.add(LogItem(15, LocalDate.now(), 15f, 15))
        logs.add(LogItem(16, LocalDate.now(), 16f, 16))
        logs.add(LogItem(17, LocalDate.now(), 17f, 17))

        val adapter = BookReadingLogAdapter(this, logs)
        listView.adapter = adapter
        book_title.text = intent.getStringExtra("TITLE")
        author.text = intent.getStringExtra("AUTHOR")
    }

}
