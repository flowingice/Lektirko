package hr.tvz.mmisic.lektirko.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository
import hr.tvz.mmisic.lektirko.data.repositories.QuestionRepository
import hr.tvz.mmisic.lektirko.data.repositories.UserRepository

class UserViewModelFactory(
    private val repository: UserRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}
