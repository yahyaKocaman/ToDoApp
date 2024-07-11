package com.t.todoapp.ui.screens

import androidx.compose.foundation.Image 
import androidx.compose.foundation.background 
import androidx.compose.foundation.layout.* 
import androidx.compose.foundation.rememberScrollState 
import androidx.compose.foundation.verticalScroll 
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment 
import androidx.compose.ui.Modifier 
import androidx.compose.ui.draw.scale 
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource 
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController 
import com.t.todoapp.R 
import com.t.todoapp.data.Book
import com.t.todoapp.ui.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)  
@Composable
fun AddBookScreen(navController: NavHostController, viewModel: BookViewModel) {
    var title by remember { mutableStateOf("") } 
    var author by remember { mutableStateOf("") } 
    var numPage by remember { mutableStateOf("") } 
    var numDay by remember { mutableStateOf("") } 

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
                    containerColor = Color.White.copy(alpha = 0.4f, red = 0.1f, green = 0.1f, blue = 0.1f) 
                )
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(1f), 
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
                        .background(color = Color.Transparent) 
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center, 
                    horizontalAlignment = Alignment.CenterHorizontally 
                ) {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f),
                            textColor = Color.Black 
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = author,
                        onValueChange = { author = it },
                        label = { Text("Author", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), 
                            textColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = numPage,
                        onValueChange = { numPage = it },
                        label = { Text("Number of Page", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), 
                            textColor = Color.Black 
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = numDay,
                        onValueChange = { numDay = it },
                        label = { Text("Number of Days Read", color = Color.Black) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White.copy(alpha = 0.6f), 
                            textColor = Color.Black 
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            val book = Book(
                                title = title,
                                author = author,
                                numPage = numPage,
                                numDay = numDay 
                            )
                            viewModel.insert(book) 
                            navController.popBackStack()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(1.0f, 0.5f, 0.2f, 0.4f) 
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
