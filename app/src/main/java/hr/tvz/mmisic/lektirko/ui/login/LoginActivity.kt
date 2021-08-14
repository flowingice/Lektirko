package hr.tvz.mmisic.lektirko.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import hr.tvz.mmisic.lektirko.R
import hr.tvz.mmisic.lektirko.data.db.entities.User
import hr.tvz.mmisic.lektirko.ui.book.BookListActivity
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_login.et_identifier
import kotlinx.android.synthetic.main.activity_login.et_lastName
import kotlinx.android.synthetic.main.activity_login.et_name
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val factory: UserViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        viewModel.getAllUsers().observe(this, {
            if (it.isNotEmpty()){
                startActivity(Intent(this, BookListActivity::class.java))
                finish()
            }
        })

        btn_login.setOnClickListener {
            val name = et_name.text.toString()
            val lastName = et_lastName.text.toString()
            val oib = et_identifier.text.toString()

            if (name.isBlank() || lastName.isBlank() || oib.isBlank()){

                Toast.makeText(this, "Sva polja moraju biti unesena", Toast.LENGTH_SHORT).show()

            }else{
                val user = User(name,lastName , oib)

                viewModel.upsert(user)
            }

        }
    }
}
