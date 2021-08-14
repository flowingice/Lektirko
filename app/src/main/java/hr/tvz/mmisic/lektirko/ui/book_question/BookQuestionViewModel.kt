package hr.tvz.mmisic.lektirko.ui.book_question

import androidx.lifecycle.ViewModel
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion
import hr.tvz.mmisic.lektirko.data.repositories.BookQuestionRepository
import hr.tvz.mmisic.lektirko.data.repositories.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookQuestionViewModel(
    private val repository: BookQuestionRepository
): ViewModel() {


    fun getAllQuestions() = repository.getAllBooks()

    fun getByBookId(bookId: Int) = repository.getByBook(bookId)
}
