package levi.lin.app.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import levi.lin.app.book.data.database.DatabaseFactory
import levi.lin.app.book.data.database.FavoriteBookDatabase
import levi.lin.app.book.data.network.KtorRemoteBookDataSource
import levi.lin.app.book.data.network.RemoteBookDataSource
import levi.lin.app.book.data.repository.DefaultBookRepository
import levi.lin.app.book.domain.BookRepository
import levi.lin.app.book.presentation.SelectedBookViewModel
import levi.lin.app.book.presentation.book_detail.BookDetailViewModel
import levi.lin.app.book.presentation.book_list.BookListViewModel
import levi.lin.app.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}