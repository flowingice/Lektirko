package hr.tvz.mmisic.lektirko.data.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import hr.tvz.mmisic.lektirko.data.db.entities.BookItem
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion

data class BookItem_BookQuestion(
    @Embedded val book: BookItem,
    @Relation(
        parentColumn = "id",
        entityColumn = "bookId"
    )
    val questions: List<BookQuestion>
)
