package hr.tvz.mmisic.lektirko.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.tvz.mmisic.lektirko.data.dao.BookDao
import hr.tvz.mmisic.lektirko.data.dao.BookItem_BookQuestionDao
import hr.tvz.mmisic.lektirko.data.dao.QuestionDao
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion

@Database(
    entities = [BookItem::class, BookQuestion::class],
    version = 3
)
abstract class LektirkoDatabase : RoomDatabase() {

    abstract fun getBookItemDao(): BookDao
    abstract fun getBookQuestionDao(): QuestionDao
    abstract fun getBookItemBookQuestionDao(): BookItem_BookQuestionDao

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
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
