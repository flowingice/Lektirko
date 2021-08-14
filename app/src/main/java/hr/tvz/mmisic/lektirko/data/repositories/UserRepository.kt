package hr.tvz.mmisic.lektirko.data.repositories

import hr.tvz.mmisic.lektirko.data.db.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.db.entities.User

class UserRepository(
    private val db: LektirkoDatabase
) {

    suspend fun upsert(item: User) = db.getUserDao().upsert(item)

    suspend fun delete(item: User) = db.getUserDao().delete(item)

    fun getAllUsers() = db.getUserDao().getAll()
}
