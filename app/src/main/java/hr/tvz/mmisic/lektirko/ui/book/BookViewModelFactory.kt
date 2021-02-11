package hr.tvz.mmisic.lektirko.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository

class BookViewModelFactory(
    private val repository: BookRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(repository) as T
    }
}
