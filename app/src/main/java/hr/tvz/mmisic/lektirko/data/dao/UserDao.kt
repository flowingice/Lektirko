package hr.tvz.mmisic.lektirko.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.User

@Dao
interface UserDao {

    //Upsert = insert + update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: User)

    @Delete
    suspend fun delete(item: User)

    @Query("SELECT * FROM tbl_user")
    fun getAll(): LiveData<List<User>>
}
