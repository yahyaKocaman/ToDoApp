package com.t.todoapp.ui.screens

import androidx.compose.foundation.Image // Resim bileşeni için.
import androidx.compose.foundation.background // Arka plan rengi eklemek için.
import androidx.compose.foundation.layout.* // Layout düzenlemeleri için.
import androidx.compose.material3.* // Material 3 bileşenleri için.
import androidx.compose.runtime.Composable // Composable fonksiyonlar için.
import androidx.compose.runtime.collectAsState // Flow'ları state olarak toplamak için.
import androidx.compose.runtime.getValue // State değerlerini almak için.
import androidx.compose.ui.Modifier // Modifikasyonlar için.
import androidx.compose.ui.graphics.Color // Renkler için.
import androidx.compose.ui.layout.ContentScale // İçerik ölçeklendirme için.
import androidx.compose.ui.res.painterResource // Resim kaynakları için.
import androidx.compose.ui.unit.dp // Birim ölçüleri için.
import androidx.navigation.NavHostController // Navigasyon için.
import com.t.todoapp.ui.BookViewModel // ViewModel sınıfı.
import com.t.todoapp.ui.components.BookList // BookList bileşeni.
import androidx.compose.material.icons.Icons // Material ikonlar için.
import androidx.compose.material.icons.filled.Add // Add ikonu için.
import androidx.compose.material.icons.filled.Check // Check ikonu için.
import androidx.compose.ui.Alignment // Hizalama için.
import androidx.compose.ui.draw.scale // Ölçekleme için.
import androidx.compose.ui.text.font.FontFamily // Yazı tipi ailesi için.
import androidx.compose.ui.text.font.FontStyle // Yazı tipi stili için.
import com.t.todoapp.R // Kaynaklar için.

@OptIn(ExperimentalMaterial3Api::class) // Deneysel Material 3 API'lerini kullanmak için.
@Composable
fun BookListScreen(navController: NavHostController, viewModel: BookViewModel) {
    val books by viewModel.allBooks.collectAsState(initial = emptyList()) // Kitap listesini state olarak toplar.

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f)), // Arka plan rengini ayarlar.
                        contentAlignment = Alignment.Center // İçeriği ortalar.
                    ) {
                        Text(
                            text = "Book List",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontStyle = FontStyle.Italic,
                                fontFamily = FontFamily.Cursive
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f) // Üst çubuğun arka plan rengini ayarlar.
                )
            )
        },
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = {
                    navController.navigate("addBook") // "addBook" ekranına gider.
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Book") // Add ikonunu gösterir.
                }
                Spacer(modifier = Modifier.height(16.dp)) // İkonlar arası boşluk bırakır.
                FloatingActionButton(onClick = {
                    navController.navigate("bookStatistics") // "bookStatistics" ekranına gider.
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Book Statistics") // Check ikonunu gösterir.
                }
            }
        }
    ) { paddingValues ->
        // BookListScreen içinde BookItem çağrısı güncellendi
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Padding değerlerini uygular.
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .scale(1f), // Resmi 1x ölçekler.
                painter = painterResource(id = R.drawable.kutuphane), // Arka plan resmini yükler.
                contentDescription = "Background image",
                contentScale = ContentScale.Crop // İçeriği kırparak ölçekler.
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp) // 16dp iç padding uygular.
            ) {
                BookList(
                    books = books, // Kitap listesi.
                    onUpdate = { book, numDay -> viewModel.update(book, numDay) }, // Kitap güncelleme fonksiyonu.
                    onDelete = { book -> viewModel.delete(book) } // Kitap silme fonksiyonu.
                )
            }
        }
    }
}
