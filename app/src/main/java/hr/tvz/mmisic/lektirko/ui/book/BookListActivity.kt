package hr.tvz.mmisic.lektirko.ui.book

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import hr.tvz.mmisic.lektirko.BookQuestionsActivity
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository

class BookListActivity : AppCompatActivity() {

    private var TAG = "BookViewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        Log.d("ListView", "Starting view with list")


        val factory = BookViewModelFactory(repository = BookRepository(LektirkoDatabase(this)))
        val viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)

        val listView: ListView = findViewById(R.id.listView)

        //listView.divider = null

        val books: ArrayList<BookItem> = ArrayList()
        books.add(BookItem("Title", "Author"))
        books.add(BookItem( "Title1", "Author1", ))
        books.add(BookItem( "Title2", "Author2", ))
        books.add(BookItem( "Title3", "Author3", ))
        books.add(BookItem( "Title4", "Author4", ))
        books.add(BookItem( "Title5", "Author5", ))
        books.add(BookItem( "Title6", "Author6", ))
        books.add(BookItem( "Title7", "Author7", ))
        books.add(BookItem( "Title8", "Author8", ))
        books.add(BookItem( "Title9", "Author9", ))


        val adapter = BookAdapter(this, books)
        listView.adapter = adapter
        setOnClickListener(listView)


    }

    fun showNewBookDialog(view: View) {
        AddBookDialog().show(supportFragmentManager, "AddBookFragment")
    }

    fun clickSave(view: View) {
        Log.i(TAG, "clickSave: ")
    }

    fun clickCancel(view: View) {
        Log.i(TAG, "clickCancel: ")
        val findFragmentByTag = supportFragmentManager.findFragmentByTag("AddBookFragment")
        if (findFragmentByTag != null) {
            (findFragmentByTag as? DialogFragment)?.dismiss()
        }
    }

    private fun setOnClickListener(listView: ListView) {
        listView.setOnItemClickListener { parent, _, position, _ ->
            val intent = Intent(this, BookQuestionsActivity::class.java).apply {
                putExtra("TITLE", (parent.getItemAtPosition(position) as BookItem).bookTitle)
                putExtra("AUTHOR", (parent.getItemAtPosition(position) as BookItem).bookAuthor)
            }
            startActivity(intent)
        }
    }

}
