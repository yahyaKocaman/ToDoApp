package com.t.todoapp.ui.screens

import androidx.compose.foundation.Image // Resim ekleme işlevi.
import androidx.compose.foundation.background // Arkaplan rengini ayarlama işlevi.
import androidx.compose.foundation.layout.* // Layout düzenlemeleri için gerekli bileşenler.
import androidx.compose.material3.* // Material 3 bileşenlerini kullanabilmek için gerekli bileşenler.
import androidx.compose.runtime.Composable // Composable fonksiyonlar için gerekli işaretleyici.
import androidx.compose.ui.Alignment // Hizalamaları belirtmek için gerekli bileşen.
import androidx.compose.ui.Modifier // Bileşenlere modifikasyonlar eklemek için gerekli bileşen.
import androidx.compose.ui.layout.ContentScale // İçeriğin ölçeklenme şeklini belirlemek için gerekli bileşen.
import androidx.compose.ui.res.painterResource // Drawable kaynaklarından resim almak için gerekli bileşen.
import androidx.navigation.NavHostController // Navigasyon işlemleri için gerekli bileşen.
import androidx.compose.material.icons.Icons // Material ikonları için gerekli bileşen.
import androidx.compose.material.icons.filled.ArrowBack // Geri butonu ikonu için gerekli bileşen.
import androidx.compose.material3.ExperimentalMaterial3Api // Deneysel Material 3 API'lerini kullanabilmek için gerekli işaretleyici.
import androidx.compose.material3.MaterialTheme // Material temalarını kullanabilmek için gerekli bileşenler.
import androidx.compose.ui.draw.scale // Bileşenlerin boyutunu ölçeklendirme işlevi.
import androidx.compose.ui.graphics.Color // Renkler için gerekli bileşen.
import androidx.compose.ui.text.font.FontFamily // Yazı tipi ailesi belirtmek için gerekli bileşen.
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp // Birim ölçülerini belirtmek için gerekli bileşen.

import com.t.todoapp.R // Kaynaklar için gerekli bileşen.
import com.t.todoapp.data.Book // Kitap veri modeli için gerekli bileşen.

// Bu ekran, kitap okuma istatistiklerini gösterir.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookStatisticsScreen(books: List<Book>, navController: NavHostController) {
    // Okunan kitaplar filtrelenir ve toplam sayfa sayısı ile toplam gün sayısı hesaplanır.
    val readBooks = books.filter { it.isRead }
    val totalPagesRead = readBooks.sumOf { it.numPage.toIntOrNull() ?: 0 }
    val totalDaysRead = readBooks.sumOf { it.numDay.toIntOrNull() ?: 0  }

    Scaffold( // Ekranın genel yapısını oluşturur.
        topBar = {
            TopAppBar( // Üst çubuk bileşeni.
                title = {
                    Text(
                        "Book Reading Statistics", // Metin içeriği.
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Cursive
                        ),
                        modifier = Modifier.background(Color.White.copy(alpha = 0.4f)) // Arka plan rengini ayarlar.
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigateUp() }, // Geri gitme işlevi.
                        modifier = Modifier.background(Color.White.copy(alpha = 0.4f)) // Arka plan rengini ayarlar.
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back") // Geri butonu ikonu.
                    }
                }
            )

        },
        content = { paddingValues -> // İçerik alanı ve kenar boşlukları belirlenir.
            Box(
                modifier = Modifier
                    .fillMaxSize() // Tüm boş alanı doldurur.
                    .padding(paddingValues) // Kenar boşluklarını belirler.
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize() // Tüm boş alanı doldurur.
                        .scale(1f), // Ölçekleme faktörü.
                    painter = painterResource(id = R.drawable.kutuphane3),
                    contentDescription = "Background image", // İçerik açıklaması.
                    contentScale = ContentScale.Crop // İçeriği kırparak ölçekler.
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) // Ortaya hizalar.
                        .background(Color.White.copy(alpha = 0.4f)) // Arka plan rengini belirler.
                        .padding(16.dp) // Kenar boşluklarını belirler.
                ) {
                    Text(
                        text = "Total Pages Read: $totalPagesRead",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        modifier = Modifier.padding(8.dp) // Kenar boşluklarını belirler.
                    )
                    Text(
                        text = "Total Days Read: $totalDaysRead",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black // Metin rengi.
                        ),
                        modifier = Modifier.padding(8.dp) // Kenar boşluklarını belirler.
                    )
                }
            }
        }
    )
}
