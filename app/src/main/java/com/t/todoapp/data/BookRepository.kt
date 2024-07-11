package com.t.todoapp.data 

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map 

class BookRepository(private val bookDao: BookDao) {

    val allBooks: Flow<List<Book>> = bookDao.getAllBooks().map { books -> 
        books.also {
            println("Fetched books: $it") 
        }
    }

    suspend fun insert(book: Book) {
        bookDao.insertBook(book) 
        println("Inserted book: $book")
    }

    suspend fun delete(book: Book) { 
        bookDao.deleteBook(book) 
        println("Deleted book: $book") 
    }

    suspend fun update(book: Book, numDay: String) { 
        bookDao.updateBook(book.copy(numDay = numDay))
        println("Updated book: $book") 
    }
}
