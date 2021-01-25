package hr.tvz.mmisic.lektirko.data.repositories

import hr.tvz.mmisic.lektirko.data.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem

class BookRepository(
    private val db: LektirkoDatabase
) {

    suspend fun upsert(item: BookItem) = db.getBookItemDao().upsert(item)

    suspend fun delete(item: BookItem) = db.getBookItemDao().delete(item)

    fun getAllBooks() = db.getBookItemDao().getAll()
}
