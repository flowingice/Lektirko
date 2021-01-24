package hr.tvz.mmisic.lektirko

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookDao {

    //Upsert = insert + update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: BookItem)

    @Delete
    suspend fun delete(item: BookItem)

    @Query("SELECT * FROM book_items")
    fun getAll(): LiveData<List<BookItem>>
}
