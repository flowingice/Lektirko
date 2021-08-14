package hr.tvz.mmisic.lektirko.ui.question

import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion

interface AddQuestionListener {

    fun onAddButtonClicked(item: BookQuestion)
}
