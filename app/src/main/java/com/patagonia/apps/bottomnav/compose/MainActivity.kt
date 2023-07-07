package com.patagonia.apps.bottomnav.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.patagonia.apps.bottomnav.compose.ui.components.BottomNavigationApp
import com.patagonia.apps.bottomnav.compose.ui.navigation.Destinations
import com.patagonia.apps.bottomnav.compose.ui.navigation.NavigationHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        Destinations.Pantalla1,
        Destinations.Pantalla2,
        Destinations.Pantalla3
    )

    Scaffold(
        bottomBar = { BottomNavigationApp(navController = navController, items = navigationItems) }
    ) {
        NavigationHost(navController)
    }
}










