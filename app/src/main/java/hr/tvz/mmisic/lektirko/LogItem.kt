package hr.tvz.mmisic.lektirko

import java.time.LocalDate

data class LogItem(
    val id: Int,
    val readingDate: LocalDate,
    val readingDuration: Int,
    val readingNoOfPages: Int
)
