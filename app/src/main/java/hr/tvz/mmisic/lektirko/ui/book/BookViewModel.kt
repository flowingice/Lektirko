package hr.tvz.mmisic.lektirko.ui.book

import androidx.lifecycle.ViewModel
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(
    private val repository: BookRepository
): ViewModel() {

    // Room provides Main safety
    fun upsert(item: BookItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: BookItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllBooks() = repository.getAllBooks()
}

