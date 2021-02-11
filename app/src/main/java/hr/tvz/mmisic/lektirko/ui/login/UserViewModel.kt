package hr.tvz.mmisic.lektirko.ui.login

import androidx.lifecycle.ViewModel
import hr.tvz.mmisic.lektirko.data.db.entities.User
import hr.tvz.mmisic.lektirko.data.repositories.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun upsert(item: User) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: User) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllUsers() = repository.getAllUsers()

}
