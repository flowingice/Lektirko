package hr.tvz.mmisic.lektirko

import android.os.Bundle
import android.util.Log
import android.view.View
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

        val books: ArrayList<ListItem> = ArrayList()
        books.add(ListItem("Title", "Author", "6", "0/2"))
        books.add(ListItem("Title1", "Author1", "61", "0/21"))
        books.add(ListItem("Title2", "Author2", "62", "0/22"))
        books.add(ListItem("Title3", "Author3", "63", "0/23"))
        books.add(ListItem("Title4", "Author4", "64", "0/24"))
        books.add(ListItem("Title5", "Author5", "65", "0/25"))
        books.add(ListItem("Title6", "Author6", "66", "0/26"))
        books.add(ListItem("Title7", "Author7", "67", "0/27"))
        books.add(ListItem("Title8", "Author8", "68", "0/28"))
        books.add(ListItem("Title9", "Author9", "69", "0/29"))


        val adapter = BookAdapter(this, books)
        listView.adapter = adapter


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
}
