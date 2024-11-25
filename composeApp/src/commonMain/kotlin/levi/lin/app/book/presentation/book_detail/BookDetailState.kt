package levi.lin.app.book.presentation.book_detail

import levi.lin.app.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
