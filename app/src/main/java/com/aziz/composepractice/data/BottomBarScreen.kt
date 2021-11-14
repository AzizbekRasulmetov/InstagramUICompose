package com.aziz.composepractice.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object AddImage : BottomBarScreen(
        route = "add_image",
        title = "Add Image",
        icon = Icons.Default.Add
    )

    object Favourites : BottomBarScreen(
        route = "favoutires",
        title = "Favoutires",
        icon = Icons.Default.Favorite
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
