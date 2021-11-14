package com.aziz.composepractice

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aziz.composepractice.data.BottomBarScreen
import com.aziz.composepractice.ui.ProfileScreen
import com.aziz.composepractice.ui.common.POST_VIEW_ROUTE
import com.aziz.composepractice.ui.common.PostView
import com.aziz.composepractice.ui.screens.*

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    Log.d("Navigation", "BottomNavGraph called")
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        Log.d("Navigation", "NavHost recomposed with destination ${navController.currentDestination}")
        composable(route = BottomBarScreen.Home.route) {
            Log.d("Navigation", "NavHost recomposed home")
            HomeScreen()
        }
        composable(route = BottomBarScreen.Search.route) {
            Log.d("Navigation", "NavHost recomposed search")
            SearchScreen()
        }
        composable(route = BottomBarScreen.AddImage.route) {
            AddImageScreen()
        }
        composable(route = BottomBarScreen.Favourites.route) {
            FavouritesScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            Log.d("Navigation", "NavHost recomposed profile")
            ProfileScreen(navController)
        }
        composable(route = POST_VIEW_ROUTE) {
            PostsScreen(navController = navController)
        }
    }
}