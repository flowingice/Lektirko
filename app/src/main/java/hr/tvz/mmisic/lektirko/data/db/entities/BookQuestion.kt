package hr.tvz.mmisic.lektirko.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_questions")
data class BookQuestion(
    val question: String,
    val answer: String
){

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
