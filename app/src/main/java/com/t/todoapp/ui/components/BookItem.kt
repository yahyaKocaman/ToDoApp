package com.t.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete 
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.t.todoapp.data.Book

@Composable
fun BookItem(
    book: Book, 
    onUpdate: (Book, Int) -> Unit, 
    onDelete: (Book) -> Unit 
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() 
            .padding(8.dp) 
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f, blue = 0.3f)) 
            .padding(16.dp) 
    ) {
        Column(modifier = Modifier.weight(1f)) { 
            Text(
                text = "Book = ${book.title}", 
                style = MaterialTheme.typography.titleLarge, 
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold 
            Text(
                text = "Author =  ${book.author}", 
                style = MaterialTheme.typography.titleMedium 
            )
            Text(
                text = "Number of Page: ${book.numPage}", 
                style = MaterialTheme.typography.titleSmall 
            )
            Text(
                text = "Number of Days Read: ${book.numDay}", 
                style = MaterialTheme.typography.titleSmall
            )
        }
        Checkbox(
            checked = book.isRead, 
            onCheckedChange = { checked ->
                onUpdate(book.copy(isRead = checked), book.numDay.toInt()) 
            }
        )
        IconButton(onClick = { onDelete(book) }) { 
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}
