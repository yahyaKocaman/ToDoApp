package com.t.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.t.todoapp.ui.BookViewModel
import com.t.todoapp.ui.NavGraph
import com.t.todoapp.ui.theme.ToDoAppTheme

/**
 * Ana aktivite sınıfı, uygulamanın giriş noktasıdır.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoApp()
        }
    }
}

/**
 * Ana Composable fonksiyonu, uygulama temasını ve navigasyon grafiğini içerir.
 */
@Composable
fun ToDoApp() {
    // Uygulama temasını belirler
    ToDoAppTheme {
        val context = LocalContext.current // Bağlamı alır
        val viewModel: BookViewModel = viewModel(
            factory = AppModule.provideViewModelFactory(context) // ViewModel'ı alır
        )
        val navController = rememberNavController() // NavController'ı hatırlar
        NavGraph(navController = navController, viewModel = viewModel) // Navigasyon grafiğini oluşturur
    }
}
