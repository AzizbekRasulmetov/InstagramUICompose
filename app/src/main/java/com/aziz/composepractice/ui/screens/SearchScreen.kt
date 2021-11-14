package com.aziz.composepractice.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aziz.composepractice.R

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ShowSearchField()
        ShowContents()
    }
}

@Composable
fun ShowSearchField(modifier: Modifier = Modifier) {
    TextField(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(40.dp)
            .padding(0.dp),
        value = "",
        onValueChange = {},
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(text = "Search", fontSize = 8.sp)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Transparent
        )
    )
}

@ExperimentalFoundationApi
@Composable
fun ShowContents(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        content = {
            val imageList: List<Int> = listOf(
                R.drawable.philipp,
                R.drawable.youtube,
                R.drawable.telegram,
                R.drawable.master_logical_thinking,
                R.drawable.learn_coding_fast
            )
            items(20) {
                Image(
                    painter = painterResource(id = imageList.get((0..4).random())),
                    contentDescription = null,
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
    )
}