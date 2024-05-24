package com.t.todoapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn // LazyColumn bileşeni için.
import androidx.compose.foundation.lazy.items // LazyColumn içindeki öğeler için.
import androidx.compose.runtime.Composable // Composable fonksiyonlar için.
import androidx.compose.ui.Modifier // Modifikasyonlar için.
import com.t.todoapp.data.Book // Book veri sınıfı.

@Composable
fun BookList(
    books: List<Book>, // Kitapların listesi.
    onUpdate: (Book, Any?) -> Unit, // Güncelleme fonksiyonu.
    onDelete: (Book) -> Unit, // Silme fonksiyonu.
    modifier: Modifier = Modifier // Modifikasyon parametresi, varsayılan değeri ile.
) {
    LazyColumn(modifier = modifier) { // Tembel sütun, performans için.
        items(books) { book -> // Kitap listesi içindeki her bir kitap için.
            BookItem(book = book, onUpdate = onUpdate, onDelete = onDelete) // BookItem bileşeni.
        }
    }
}
