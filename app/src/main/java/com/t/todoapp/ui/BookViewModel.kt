package com.t.todoapp.ui

import androidx.lifecycle.ViewModel // Android Architecture Components ViewModel sınıfı.
import androidx.lifecycle.ViewModelProvider // ViewModel'ı oluşturmak için sağlayıcı sınıf.
import androidx.lifecycle.viewModelScope // ViewModel kapsamını başlatmak için kullanılan kapsam işlevi.
import com.t.todoapp.data.Book // Kitap veri modeli.
import com.t.todoapp.data.BookRepository // Kitap verilerini yöneten depo sınıfı.
import kotlinx.coroutines.launch /* Asenkron işlemleri yönetmek için kullanılan coroutines bileşeni.
                                                            uzun süren işlemleri başlatmak için kullanırız*/

// Kitap verileriyle etkileşimi yöneten ViewModel sınıfı.
class BookViewModel(private val repository: BookRepository) : ViewModel() {

    // Tüm kitapları gösteren LiveData.
    val allBooks = repository.allBooks

    // Bir kitabı ekleme işlevi.
    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }

    // Bir kitabı silme işlevi.
    fun delete(book: Book) = viewModelScope.launch {
        repository.delete(book)
    }

    // Bir kitabı güncelleme işlevi.
    fun update(book: Book, numDay: Any?) = viewModelScope.launch {
        repository.update(book, numDay.toString())
    }
}

// ViewModel'ı oluşturmak için fabrika sınıfı.
class BookViewModelFactory(private val repository: BookRepository) : ViewModelProvider.Factory {
    // ViewModel oluşturma işlevi.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
