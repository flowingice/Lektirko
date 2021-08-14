package hr.tvz.mmisic.lektirko.data.repositories

import hr.tvz.mmisic.lektirko.data.db.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem

class BookQuestionRepository(
    private val db: LektirkoDatabase
) {

    fun getAllBooks() = db.getBookItemBookQuestionDao().getAll()

    fun getByBook(bookId: Int) = db.getBookItemBookQuestionDao().getByBookId(bookId)
}
