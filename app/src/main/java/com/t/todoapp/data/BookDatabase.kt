package com.t.todoapp.data // Kodun hangi pakette olduğunu belirtiyor.

import androidx.room.Database // Room veritabanı kütüphanesi.
import androidx.room.RoomDatabase // RoomDatabase sınıfı.

@Database(entities = [Book::class], version = 1, exportSchema = false) // Veritabanı yapılandırması.
abstract class BookDatabase : RoomDatabase() { // Veritabanı sınıfı.
    abstract fun bookDao(): BookDao // BookDao arayüzünü döner.
}
