package hr.tvz.mmisic.lektirko.ui.question

import androidx.lifecycle.ViewModel
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion
import hr.tvz.mmisic.lektirko.data.repositories.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(
    private val repository: QuestionRepository
): ViewModel() {

    fun upsert(item: BookQuestion) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: BookQuestion) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllQuestions() = repository.getAllQuestions()

    fun getById(id: Int) = repository.getById(id)
}
