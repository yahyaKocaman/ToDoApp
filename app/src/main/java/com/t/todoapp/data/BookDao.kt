package com.t.todoapp.data // Kodun hangi pakette olduğunu belirtiyor.

import androidx.room.* // Room ile ilgili gerekli kütüphaneleri ekliyor.
import kotlinx.coroutines.flow.Flow // Flow ile ilgili kütüphaneyi ekliyor.

@Dao // Bu arayüzün bir DAO (Data Access Object) olduğunu belirtiyor.
interface BookDao {
    @Query("SELECT * FROM books") // Tablodaki tüm kitapları seçer.
    fun getAllBooks(): Flow<List<Book>> // Kitap listesini döner, Flow ile sürekli güncellenir.

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Çakışma olursa mevcut kaydı değiştirerek ekler.
    suspend fun insertBook(book: Book) // Bir kitap ekler.

    @Delete // Verilen kitabı siler.
    suspend fun deleteBook(book: Book) // Bir kitabı siler.

    @Update // Verilen kitabı günceller.
    suspend fun updateBook(book: Book) // Bir kitabı günceller.
}
