package hr.tvz.mmisic.lektirko.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_questions")
data class BookQuestion(
    val question: String,
    var answer: String?,
    val bookId: Int
){

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
