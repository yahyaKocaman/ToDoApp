package com.t.todoapp

import android.content.Context
import androidx.room.Room
import com.t.todoapp.data.BookDatabase
import com.t.todoapp.data.BookRepository
import com.t.todoapp.ui.BookViewModelFactory

object AppModule {
    private var database: BookDatabase? = null


    private fun provideDatabase(context: Context): BookDatabase {
        return database ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext, 
                BookDatabase::class.java,
                "book_database" 
            ).build() 
            database = instance 
            instance
        }
    }

 
    private fun provideRepository(context: Context): BookRepository {
        val database = provideDatabase(context)
        return BookRepository(database.bookDao()) 
    }

 
    fun provideViewModelFactory(context: Context): BookViewModelFactory {
        val repository = provideRepository(context)
        return BookViewModelFactory(repository) 
    }
}
