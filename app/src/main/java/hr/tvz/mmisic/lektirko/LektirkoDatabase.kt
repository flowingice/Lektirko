package hr.tvz.mmisic.lektirko

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BookItem::class],
    version = 1
)
abstract class LektirkoDatabase : RoomDatabase() {

    abstract fun getBookItemDao(): BookDao

    companion object {
        @Volatile
        private var instance: LektirkoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context)
                .also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            LektirkoDatabase::class.java,
            "LektirkoDB"
        ).build()
    }
}
