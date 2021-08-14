package hr.tvz.mmisic.lektirko.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    val firstName: String,
    var lastName: String,
    val oib: String
){

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
