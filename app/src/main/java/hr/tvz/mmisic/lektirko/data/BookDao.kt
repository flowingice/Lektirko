package hr.tvz.mmisic.lektirko.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem

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
