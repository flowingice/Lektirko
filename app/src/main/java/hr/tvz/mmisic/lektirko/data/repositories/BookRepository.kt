package hr.tvz.mmisic.lektirko.data.repositories

import hr.tvz.mmisic.lektirko.data.db.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem

class BookRepository(
    private val db: LektirkoDatabase
) {

    suspend fun upsert(item: BookItem) = db.getBookItemDao().upsert(item)

    suspend fun delete(item: BookItem) = db.getBookItemDao().delete(item)

    fun getAllBooks() = db.getBookItemDao().getAll()

    fun getFilteredBooks(query: String) = db.getBookItemDao().getFilteredBooks(query)
}
