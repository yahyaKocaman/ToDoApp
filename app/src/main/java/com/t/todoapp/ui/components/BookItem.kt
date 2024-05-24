package com.t.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete // Silme ikonu için.
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.t.todoapp.data.Book // Book veri sınıfı.

@Composable
fun BookItem(
    book: Book, // Kitap verisi.
    onUpdate: (Book, Int) -> Unit, // Güncelleme fonksiyonu, numDay parametresiyle.
    onDelete: (Book) -> Unit // Silme fonksiyonu.
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Tüm genişliği kapla.
            .padding(8.dp) // Dış kenar boşluğu.
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f, blue = 0.3f)) // Arka plan rengi.
            .padding(16.dp) // İç kenar boşluğu.
    ) {
        Column(modifier = Modifier.weight(1f)) { // Sütun, genişlik ayarlı.
            Text(
                text = "Book = ${book.title}", // Kitap başlığı.
                style = MaterialTheme.typography.titleLarge, // Büyük başlık stili.
                fontStyle = FontStyle.Italic, // İtalik yazı stili.
                fontWeight = FontWeight.Bold // Kalın yazı tipi.
            )
            Text(
                text = "Author =  ${book.author}", // Kitap yazarı.
                style = MaterialTheme.typography.titleMedium // Orta boy başlık stili.
            )
            Text(
                text = "Number of Page: ${book.numPage}", // Sayfa sayısı.
                style = MaterialTheme.typography.titleSmall // Küçük boy başlık stili.
            )
            Text(
                text = "Number of Days Read: ${book.numDay}", // Okuma süresi (gün).
                style = MaterialTheme.typography.titleSmall // Küçük boy başlık stili.
            )
        }
        Checkbox(
            checked = book.isRead, // Okunmuş mu?
            onCheckedChange = { checked ->
                onUpdate(book.copy(isRead = checked), book.numDay.toInt()) // Kitap durumu güncellenir, numDay ile.
            }
        )
        IconButton(onClick = { onDelete(book) }) { // Silme butonu.
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete") // Silme ikonu.
        }
    }
}
