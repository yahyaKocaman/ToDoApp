package com.t.todoapp.data

import androidx.room.* 
import kotlinx.coroutines.flow.Flow 
@Dao 
interface BookDao {
    @Query("SELECT * FROM books") 
    fun getAllBooks(): Flow<List<Book>> 

    @Insert(onConflict = OnConflictStrategy.REPLACE) 
    suspend fun insertBook(book: Book)

    @Delete 
    suspend fun deleteBook(book: Book)

    @Update 
    suspend fun updateBook(book: Book)
    
}
