package com.t.todoapp.ui

import com.t.todoapp.ui.screens.BookStatisticsScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.t.todoapp.ui.screens.AddBookScreen
import com.t.todoapp.ui.screens.BookListScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: BookViewModel) {

    NavHost(navController = navController, startDestination = "bookList") {
      
        composable("bookList") {
            
            BookListScreen(navController = navController, viewModel = viewModel)
        }
  
        composable("addBook") {
          
            AddBookScreen(navController = navController, viewModel = viewModel)
        }
      
        composable("bookStatistics") {
           
            BookStatisticsScreen(
         
                books = viewModel.allBooks.collectAsState(initial = emptyList()).value,
                navController = navController
            )
        }
    }
}
