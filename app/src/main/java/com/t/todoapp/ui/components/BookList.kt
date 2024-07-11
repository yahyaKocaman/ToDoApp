package com.t.todoapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn 
import androidx.compose.foundation.lazy.items 
import androidx.compose.runtime.Composable 
import androidx.compose.ui.Modifier 
import com.t.todoapp.data.Book 

@Composable
fun BookList(
    books: List<Book>, 
    onUpdate: (Book, Any?) -> Unit, 
    onDelete: (Book) -> Unit, 
    modifier: Modifier = Modifier 
) {
    LazyColumn(modifier = modifier) { 
        items(books) { book -> 
            BookItem(book = book, onUpdate = onUpdate, onDelete = onDelete)
        }
    }
}
