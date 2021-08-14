package hr.tvz.mmisic.lektirko.ui.question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository
import hr.tvz.mmisic.lektirko.data.repositories.QuestionRepository

class QuestionViewModelFactory(
    private val repository: QuestionRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuestionViewModel(repository) as T
    }
}
