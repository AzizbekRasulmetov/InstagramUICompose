package com.aziz.composepractice.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aziz.composepractice.ui.common.PostView

@Composable
fun PostsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Posts",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, "")
                    }
                }
            )
        }
    ) {
        LazyColumn(
            content = {
                items(10) {
                    PostView(navController = navController)
                }
            })
    }
}