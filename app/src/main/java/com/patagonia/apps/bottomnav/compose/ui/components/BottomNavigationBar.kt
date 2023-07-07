package com.patagonia.apps.bottomnav.compose.ui.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.patagonia.apps.bottomnav.compose.ui.navigation.Destinations
import com.patagonia.apps.bottomnav.compose.ui.navigation.currentRoute

@Composable
fun BottomNavigationApp(
    navController: NavHostController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController)

    BottomAppBar(
        contentColor = Color.White,
        containerColor = Color.LightGray,
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}