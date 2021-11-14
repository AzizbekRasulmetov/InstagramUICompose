package com.aziz.composepractice.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aziz.composepractice.R

const val POST_VIEW_ROUTE = "post_view"

@Composable
fun PostView(navController: NavController) {

        Column() {
            TopBar(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.master_logical_thinking),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )
            PostButtons(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth()
            )
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "rasulmetov_a Post description goes here. Just adding to test this post description.",
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 10.dp),
                text = "1 January",
                fontSize = 10.sp,
                color = Color.LightGray
            )
        }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.philipp),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 0.dp,
                    color = Color.Transparent,
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
                .size(30.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "rasulmetov_a",
            fontSize = 12.sp,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dotmenu),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .padding(3.dp)
            )
        }
    }
}

@Composable
fun PostButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_mode_comment_24),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_send_24),
                contentDescription = ""
            )
        }
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.ic_baseline_bookmark_border_24), "")
            }
        }
    }
}