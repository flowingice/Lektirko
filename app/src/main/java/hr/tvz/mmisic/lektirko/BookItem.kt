package hr.tvz.mmisic.lektirko

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_items")
data class BookItem(
    val bookTitle: String,
    val bookAuthor: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
