package levi.lin.app.book.data.network

import levi.lin.app.book.data.dto.BookWorkDto
import levi.lin.app.book.data.dto.SearchResponseDto
import levi.lin.app.core.domain.DataError
import levi.lin.app.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}