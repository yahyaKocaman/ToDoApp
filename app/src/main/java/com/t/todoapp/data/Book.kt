package com.t.todoapp.data // Kodun hangi pakette olduğunu belirtiyor.

import androidx.room.Entity // Room veritabanı için gerekli.
import androidx.room.PrimaryKey // Birincil anahtar için gerekli.

@Entity(tableName = "books") // Bu sınıfı "books" tablosu olarak tanımlıyor.
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Otomatik artan ID, birincil anahtar.
    val title: String, // Kitabın başlığı.
    val author: String,
    val numPage: String,
    val numDay: String,
    val isRead: Boolean = false, // Kitap okundu mu? (Varsayılan: hayır).
)
