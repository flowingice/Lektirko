package hr.tvz.mmisic.lektirko

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class BookListActivity : AppCompatActivity() {

    private var TAG = "BookViewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        Log.d("ListView", "Starting view with list")

        val listView: ListView = findViewById(R.id.listView)

        //listView.divider = null

        val books: ArrayList<BookItem> = ArrayList()
        books.add(BookItem(1, "Title", "Author", "6", "0/2"))
        books.add(BookItem(12,"Title1", "Author1", "61", "0/21"))
        books.add(BookItem(13,"Title2", "Author2", "62", "0/22"))
        books.add(BookItem(14,"Title3", "Author3", "63", "0/23"))
        books.add(BookItem(15,"Title4", "Author4", "64", "0/24"))
        books.add(BookItem(16,"Title5", "Author5", "65", "0/25"))
        books.add(BookItem(17,"Title6", "Author6", "66", "0/26"))
        books.add(BookItem(18,"Title7", "Author7", "67", "0/27"))
        books.add(BookItem(19,"Title8", "Author8", "68", "0/28"))
        books.add(BookItem(10,"Title9", "Author9", "69", "0/29"))


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
        if (findFragmentByTag != null){
            (findFragmentByTag as? DialogFragment)?.dismiss()
        }
    }

    private fun setOnClickListener(listView: ListView){
        listView.setOnItemClickListener { parent, _, position, _ ->
            val intent = Intent(this, BookQuestionsActivity::class.java).apply {
                putExtra("TITLE", (parent.getItemAtPosition(position) as BookItem).bookTitle)
                putExtra("AUTHOR", (parent.getItemAtPosition(position) as BookItem).bookAuthor)
            }
            startActivity(intent)
        }
    }

}
