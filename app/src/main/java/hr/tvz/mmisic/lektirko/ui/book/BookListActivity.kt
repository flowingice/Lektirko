package hr.tvz.mmisic.lektirko.ui.book

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    private var TAG = "BookViewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        Log.d("ListView", "Starting view with list")


        val factory = BookViewModelFactory(repository = BookRepository(LektirkoDatabase(this)))
        val viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)


        val adapter = BookAdapter(listOf(), viewModel)

        rvBookItems.layoutManager = LinearLayoutManager(this)
        rvBookItems.adapter = adapter

        viewModel.getAllBooks().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


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

}
