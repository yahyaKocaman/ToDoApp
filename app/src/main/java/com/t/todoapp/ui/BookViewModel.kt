package com.t.todoapp.ui

import androidx.lifecycle.ViewModel 
import androidx.lifecycle.ViewModelProvider 
import androidx.lifecycle.viewModelScope 
import com.t.todoapp.data.Book
import com.t.todoapp.data.BookRepository 
import kotlinx.coroutines.launch
                                                            


class BookViewModel(private val repository: BookRepository) : ViewModel() {

   
    val allBooks = repository.allBooks

  
    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }

   
    fun delete(book: Book) = viewModelScope.launch {
        repository.delete(book)
    }

    fun update(book: Book, numDay: Any?) = viewModelScope.launch {
        repository.update(book, numDay.toString())
    }
}


class BookViewModelFactory(private val repository: BookRepository) : ViewModelProvider.Factory {
   
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
