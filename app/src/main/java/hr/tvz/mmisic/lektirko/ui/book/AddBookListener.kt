package hr.tvz.mmisic.lektirko.ui.book

import hr.tvz.mmisic.lektirko.data.db.entities.BookItem

interface AddBookListener {

    fun onAddButtonClicked(item: BookItem)
}
