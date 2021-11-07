package com.aziz.composepractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.aziz.composepractice.ui.ProfileScreen
import com.aziz.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ProfileScreen()
                }

                println("This is added to the second commit")
            }
        }
    }
}


//@Preview(
//    name = "Preview 1",
//    group = "Group 1",
//    showBackground = true,
//    showSystemUi = true,
//    device = Devices.NEXUS_6
//    // uiMode = UI_MODE_NIGHT_YES
//)
//@Preview(
//    name = "Preview 2",
//    group = "Group 2",
//    backgroundColor = 0xFF03DAC5,
//    showBackground = true
//)


