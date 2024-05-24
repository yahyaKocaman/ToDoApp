package com.t.todoapp.ui.screens

import androidx.compose.foundation.Image // Resim bileşeni için.
import androidx.compose.foundation.background // Arka plan rengi eklemek için.
import androidx.compose.foundation.layout.* // Layout düzenlemeleri için.
import androidx.compose.foundation.rememberScrollState // Scroll state için.
import androidx.compose.foundation.verticalScroll // Dikey scroll için.
import androidx.compose.material3.*
import androidx.compose.runtime.* // State yönetimi için.
import androidx.compose.ui.Alignment // Hizalama için.
import androidx.compose.ui.Modifier // Modifikasyonlar için.
import androidx.compose.ui.draw.scale // Ölçekleme için.
import androidx.compose.ui.graphics.Color // Renkler için.
import androidx.compose.ui.layout.ContentScale // İçerik ölçeklendirme için.
import androidx.compose.ui.res.painterResource // Resim kaynakları için.
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController // Navigasyon için.
import com.t.todoapp.R //resiml kaynakları için .
import com.t.todoapp.data.Book // Book veri sınıfı.
import com.t.todoapp.ui.BookViewModel // ViewModel sınıfı.

@OptIn(ExperimentalMaterial3Api::class)  // Deneysel Material 3 API'lerini kullanmak için gerekli.
@Composable
fun AddBookScreen(navController: NavHostController, viewModel: BookViewModel) {
    var title by remember { mutableStateOf("") } // Kitap başlığı için state.
    var author by remember { mutableStateOf("") } // Yazar adı için state.
    var numPage by remember { mutableStateOf("") } // Sayfa sayısı için state.
    var numDay by remember { mutableStateOf("") } // Okuma gün sayısı için state.

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Add Book Page",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontStyle = FontStyle.Italic,
                                fontFamily = FontFamily.Cursive
                            ),
                            modifier = Modifier.background(Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f))
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f) // Üst çubuğun arka plan rengini ayarlar.
                )
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding() // Durum çubuğu boşluğunu ayarlar.
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(1f), // Resmi 1x ölçekler.
                    painter = painterResource(id = R.drawable.kutuphane2),
                    contentDescription = "Background image",
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxWidth()
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(state = rememberScrollState())
                        .background(color = Color.Transparent) // Arka plan rengini şeffaf yapar.
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center, // Dikeyde ortalar.
                    horizontalAlignment = Alignment.CenterHorizontally // Yatayda ortalar.
                ) {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), // TextField'in arka plan rengini ayarlar.
                            textColor = Color.Black // Yazı rengini siyah yapar.
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = author,
                        onValueChange = { author = it },
                        label = { Text("Author", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), // TextField'in arka plan rengini ayarlar.
                            textColor = Color.Black // Yazı rengini siyah yapar.
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = numPage,
                        onValueChange = { numPage = it },
                        label = { Text("Number of Page", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), // TextField'in arka plan rengini ayarlar.
                            textColor = Color.Black // Yazı rengini siyah yapar.
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = numDay,
                        onValueChange = { numDay = it },
                        label = { Text("Number of Days Read", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), // TextField'in arka plan rengini ayarlar.
                            textColor = Color.Black // Yazı rengini siyah yapar.
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            val book = Book(
                                title = title,
                                author = author,
                                numPage = numPage,
                                numDay = numDay // Kullanıcıdan alınan numDay bilgisini ekler.
                            )
                            viewModel.insert(book) // Kitabı veritabanına ekler.
                            navController.popBackStack() // Geriye gider.
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(1.0f, 0.5f, 0.2f, 0.4f) // Butonun arka plan rengini ayarlar.
                        )
                    ) {
                        Text(
                            "Add To Library",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontStyle = FontStyle.Italic,
                                color = Color.Black
                            ),
                            modifier = Modifier.background(Color.Transparent)
                        )
                    }
                }
            }
        }
    )
}
