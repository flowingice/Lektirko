package hr.tvz.mmisic.lektirko.ui.book

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.ui.settings.font.FontActivity
import hr.tvz.mmisic.lektirko.ui.settings.font.FontUtil
import kotlinx.android.synthetic.main.activity_book_list.add_new_book_item
import kotlinx.android.synthetic.main.activity_book_list.btn_settings
import kotlinx.android.synthetic.main.activity_book_list.rvBookItems
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class BookListActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val factory: BookViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FontUtil.updateTheme(this)
        setContentView(R.layout.activity_book_list)
        Log.d("ListView", "Starting view with list")


        val viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)


        val adapter = BookAdapter(listOf(), viewModel)

        rvBookItems.layoutManager = LinearLayoutManager(this)
        rvBookItems.adapter = adapter

        viewModel.getAllBooks().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        add_new_book_item.setOnClickListener {
            val dialog = AddBookDialog(this,
                object : AddBookListener {
                    override fun onAddButtonClicked(item: BookItem) {
                        viewModel.upsert(item)
                    }
                })
            dialog.show()
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        btn_settings.setOnClickListener{
            startActivity(Intent(this, FontActivity::class.java))
        }


    }


}
