package com.t.todoapp.ui

import com.t.todoapp.ui.screens.BookStatisticsScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.t.todoapp.ui.screens.AddBookScreen
import com.t.todoapp.ui.screens.BookListScreen

/**
 * Uygulamanın gezinme grafiğini oluşturan ana bileşen.
 * Farklı rotalara sahip ekranları belirler.
 */
@Composable
fun NavGraph(navController: NavHostController, viewModel: BookViewModel) {
    // Jetpack Navigation ile belirli rotalara sahip ekranlar arasında gezinme sağlanır
    NavHost(navController = navController, startDestination = "bookList") {
        // Kitap listesi ekranı
        composable("bookList") {
            // Kitap listesi bileşeni
            BookListScreen(navController = navController, viewModel = viewModel)
        }
        // Yeni kitap ekleme ekranı
        composable("addBook") {
            // Yeni kitap ekleme bileşeni
            AddBookScreen(navController = navController, viewModel = viewModel)
        }
        // Kitap istatistikleri ekranı
        composable("bookStatistics") {
            // Kitap istatistikleri bileşeni
            BookStatisticsScreen(
                // ViewModel'den alınan kitap listesi verisi kullanılarak istatistikler görüntülenir
                books = viewModel.allBooks.collectAsState(initial = emptyList()).value,
                navController = navController
            )
        }
    }
}
