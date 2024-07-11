package com.t.todoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background 
import androidx.compose.foundation.layout.* 
import androidx.compose.material3.* 
import androidx.compose.runtime.Composable 
import androidx.compose.ui.Alignment 
import androidx.compose.ui.Modifier 
import androidx.compose.ui.layout.ContentScale 
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack 
import androidx.compose.material3.ExperimentalMaterial3Api 
import androidx.compose.material3.MaterialTheme 
import androidx.compose.ui.draw.scale 
import androidx.compose.ui.graphics.Color 
import androidx.compose.ui.text.font.FontFamily 
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.t.todoapp.R 
import com.t.todoapp.data.Book 


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookStatisticsScreen(books: List<Book>, navController: NavHostController) {
   
    val readBooks = books.filter { it.isRead }
    val totalPagesRead = readBooks.sumOf { it.numPage.toIntOrNull() ?: 0 }
    val totalDaysRead = readBooks.sumOf { it.numDay.toIntOrNull() ?: 0  }

    Scaffold( 
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Book Reading Statistics", 
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Cursive
                        ),
                        modifier = Modifier.background(Color.White.copy(alpha = 0.4f)) 
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigateUp() }, 
                        modifier = Modifier.background(Color.White.copy(alpha = 0.4f)) 
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

        },
        content = { paddingValues -> 
            Box(
                modifier = Modifier
                    .fillMaxSize() 
                    .padding(paddingValues) 
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize() 
                        .scale(1f),
                    painter = painterResource(id = R.drawable.kutuphane3),
                    contentDescription = "Background image",
                    contentScale = ContentScale.Crop 
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) 
                        .background(Color.White.copy(alpha = 0.4f)) 
                        .padding(16.dp) 
                ) {
                    Text(
                        text = "Total Pages Read: $totalPagesRead",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        modifier = Modifier.padding(8.dp) 
                    )
                    Text(
                        text = "Total Days Read: $totalDaysRead",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black 
                        ),
                        modifier = Modifier.padding(8.dp) 
                    )
                }
            }
        }
    )
}
