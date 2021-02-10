package hr.tvz.mmisic.lektirko.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion

@Dao
interface QuestionDao {

    //Upsert = insert + update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: BookQuestion)

    @Delete
    suspend fun delete(item: BookQuestion)

    @Query("SELECT * FROM book_questions")
    fun getAll(): LiveData<List<BookQuestion>>

    @Query("SELECT * FROM book_questions where id = :id")
    fun getById(id: Int): LiveData<List<BookQuestion>>
}
