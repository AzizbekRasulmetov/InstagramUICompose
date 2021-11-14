package com.aziz.composepractice.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aziz.composepractice.BottomNavGraph
import com.aziz.composepractice.data.BottomBarScreen

@ExperimentalFoundationApi
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { 
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.AddImage,
        BottomBarScreen.Favourites,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.d("Navigation", "BottomBar called")
    val currentDestination = navBackStackEntry?.destination
    Log.d("Navigation", "BottomBar current desitanation: $currentDestination")
    
    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        icon = {
            Icon(imageVector = screen.icon, contentDescription = null, tint = Color.Black)
        },
        selected = currentDestination?.hierarchy?.any {
                     it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        },
        modifier = Modifier.background(
            color = Color.White
        )
    )
}