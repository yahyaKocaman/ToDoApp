package com.t.todoapp

import android.content.Context
import androidx.room.Room
import com.t.todoapp.data.BookDatabase
import com.t.todoapp.data.BookRepository
import com.t.todoapp.ui.BookViewModelFactory

/**
 * Uygulama modülü, veritabanı ve repository gibi bağımlılıkları yönetir.
 */
object AppModule {
    private var database: BookDatabase? = null

    /**
     * Veritabanı erişimini sağlar.
     * Eğer bir veritabanı oluşturulmadıysa, yeni bir tane oluşturur.
     */
    private fun provideDatabase(context: Context): BookDatabase {
        return database ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext, // Uygulama bağlamı için bir bağlam nesnesi alır
                BookDatabase::class.java, // Veritabanı sınıfını belirtir
                "book_database" // Veritabanı adı
            ).build() // Veritabanı oluşturur
            database = instance // Veritabanı örneğini saklar
            instance // Veritabanı örneğini döndürür
        }
    }

    /**
     * Repository sağlar.
     * Veritabanı ve DAO kullanarak bir repository oluşturur.
     */
    private fun provideRepository(context: Context): BookRepository {
        val database = provideDatabase(context) // Veritabanı örneğini alır
        return BookRepository(database.bookDao()) // BookRepository örneği oluşturur ve döndürür
    }

    /**
     * ViewModelFactory sağlar.
     * Repository kullanarak bir ViewModelFactory oluşturur.
     */
    fun provideViewModelFactory(context: Context): BookViewModelFactory {
        val repository = provideRepository(context) // Repository örneğini alır
        return BookViewModelFactory(repository) // ViewModelFactory örneği oluşturur ve döndürür
    }
}
