package hr.tvz.mmisic.lektirko

import android.app.Application
import hr.tvz.mmisic.lektirko.data.db.LektirkoDatabase
import hr.tvz.mmisic.lektirko.data.repositories.BookQuestionRepository
import hr.tvz.mmisic.lektirko.data.repositories.BookRepository
import hr.tvz.mmisic.lektirko.data.repositories.QuestionRepository
import hr.tvz.mmisic.lektirko.ui.book.BookViewModelFactory
import hr.tvz.mmisic.lektirko.ui.book_question.BookQuestionViewModelFactory
import hr.tvz.mmisic.lektirko.ui.question.QuestionViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class Lektirko : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@Lektirko))
        bind() from singleton { LektirkoDatabase(instance()) }
        bind() from singleton { BookRepository(instance()) }
        bind() from provider { BookViewModelFactory(instance()) }
        bind() from singleton { QuestionRepository(instance()) }
        bind() from provider { QuestionViewModelFactory(instance()) }
        bind() from singleton { BookQuestionRepository(instance()) }
        bind() from provider { BookQuestionViewModelFactory(instance()) }
    }

}
