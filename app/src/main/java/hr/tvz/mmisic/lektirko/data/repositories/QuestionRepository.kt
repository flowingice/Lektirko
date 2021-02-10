package hr.tvz.mmisic.lektirko.data.repositories

import hr.tvz.mmisic.lektirko.data.db.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.db.entities.BookQuestion

class QuestionRepository(
    private val db: LektirkoDatabase
) {

    suspend fun upsert(item: BookQuestion) = db.getBookQuestionDao().upsert(item)

    suspend fun delete(item: BookQuestion) = db.getBookQuestionDao().delete(item)

    fun getAllQuestions() = db.getBookQuestionDao().getAll()
}
