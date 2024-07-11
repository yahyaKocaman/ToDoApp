package com.t.todoapp.ui.screens

import androidx.compose.foundation.Image 
import androidx.compose.foundation.background 
import androidx.compose.foundation.layout.* 
import androidx.compose.material3.* 
import androidx.compose.runtime.Composable 
import androidx.compose.runtime.collectAsState 
import androidx.compose.runtime.getValue 
import androidx.compose.ui.Modifier 
import androidx.compose.ui.graphics.Color 
import androidx.compose.ui.layout.ContentScale 
import androidx.compose.ui.res.painterResource 
import androidx.compose.ui.unit.dp 
import androidx.navigation.NavHostController 
import com.t.todoapp.ui.BookViewModel
import com.t.todoapp.ui.components.BookList 
import androidx.compose.material.icons.Icons 
import androidx.compose.material.icons.filled.Add 
import androidx.compose.material.icons.filled.Check 
import androidx.compose.ui.Alignment 
import androidx.compose.ui.draw.scale 
import androidx.compose.ui.text.font.FontFamily 
import androidx.compose.ui.text.font.FontStyle 
import com.t.todoapp.R 

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(navController: NavHostController, viewModel: BookViewModel) {
    val books by viewModel.allBooks.collectAsState(initial = emptyList()) 

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
                    containerColor = Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f)
                )
            )
        },
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = {
                    navController.navigate("addBook") 
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Book") 
                }
                Spacer(modifier = Modifier.height(16.dp))
                FloatingActionButton(onClick = {
                    navController.navigate("bookStatistics") 
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Book Statistics") 
                }
            }
        }
    ) { paddingValues ->
       
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .scale(1f),
                painter = painterResource(id = R.drawable.kutuphane), 
                contentDescription = "Background image",
                contentScale = ContentScale.Crop 
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp) 
            ) {
                BookList(
                    books = books, 
                    onUpdate = { book, numDay -> viewModel.update(book, numDay) }, 
                    onDelete = { book -> viewModel.delete(book) } 
                )
            }
        }
    }
}
