package hr.tvz.mmisic.lektirko.ui.book_question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.tvz.mmisic.lektirko.data.repositories.BookQuestionRepository

class BookQuestionViewModelFactory(
    private val repository: BookQuestionRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookQuestionViewModel(repository) as T
    }
}
