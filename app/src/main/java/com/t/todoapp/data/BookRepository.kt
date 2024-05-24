package com.t.todoapp.data // Kodun hangi pakette olduğunu belirtiyor.

import kotlinx.coroutines.flow.Flow // Flow kütüphanesi.
import kotlinx.coroutines.flow.map // Flow içindeki map fonksiyonu.

class BookRepository(private val bookDao: BookDao) { // BookDao'yu kullanan depo sınıfı.

    val allBooks: Flow<List<Book>> = bookDao.getAllBooks().map { books -> // Tüm kitapları alır ve her seferinde map ile işleyip yazdırır.
        books.also {
            println("Fetched books: $it") // Alınan kitapları yazdırır.
        }
    }

    suspend fun insert(book: Book) { // Kitap ekleme fonksiyonu.
        bookDao.insertBook(book) // Kitabı DAO'ya ekler.
        println("Inserted book: $book") // Eklenen kitabı yazdırır.
    }

    suspend fun delete(book: Book) { // Kitap silme fonksiyonu.
        bookDao.deleteBook(book) // Kitabı DAO'dan siler.
        println("Deleted book: $book") // Silinen kitabı yazdırır.
    }

    suspend fun update(book: Book, numDay: String) { // Kitap güncelleme fonksiyonu, numDay parametresi eklenmiş.
        bookDao.updateBook(book.copy(numDay = numDay)) // Kitabın numDay alanını günceller.
        println("Updated book: $book") // Güncellenen kitabı yazdırır.
    }
}
