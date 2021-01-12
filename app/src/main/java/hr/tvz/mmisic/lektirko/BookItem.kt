package hr.tvz.mmisic.lektirko

data class BookItem(
    var bookId: Int,
    val bookTitle: String,
    val bookAuthor: String,
    val hoursRead: String,
    val questionsAnswered: String
)
