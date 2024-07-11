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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoApp()
        }
    }
}


@Composable
fun ToDoApp() {

    ToDoAppTheme {
        val context = LocalContext.current 
        val viewModel: BookViewModel = viewModel(
            factory = AppModule.provideViewModelFactory(context) 
        )
        val navController = rememberNavController()
        NavGraph(navController = navController, viewModel = viewModel)
    }
}
