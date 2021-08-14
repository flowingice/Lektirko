package hr.tvz.mmisic.lektirko.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import hr.tvz.mmisic.lektirko.data.db.entities.relations.BookItem_BookQuestion

@Dao
interface BookItem_BookQuestionDao {

    @Transaction
    @Query("SELECT * FROM book_items")
    fun getAll(): LiveData<List<BookItem_BookQuestion>>

    @Transaction
    @Query("SELECT * FROM book_items where id = :bookId")
    fun getByBookId(bookId: Int): LiveData<List<BookItem_BookQuestion>>
}
