package com.example.automobile2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.automobile.R
import com.example.automobile.ui.theme.AutoMobileTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

sealed class Navigation(val route: String, @DrawableRes val icon: Int, val title: String) {
    object Home : Navigation("home", R.drawable.ic_home, "Home")
    object Favorites: Navigation("favorites", R.drawable.ic_favorites, "Favorites")
    object Map: Navigation("map", R.drawable.ic_map, "Map")
    object Notifications: Navigation("notifications", R.drawable.ic_notifications, "Notifications")
    object Profile: Navigation("profile", R.drawable.ic_profile, "Profile")
}

val items = listOf(
    Navigation.Home,
    Navigation.Favorites,
    Navigation.Map,
    Navigation.Notifications,
    Navigation.Profile
)

@Composable
fun BottomNavigationBar(navController: NavController, items: List<Navigation>) {
    BottomNavigation(
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
    ) {
        val currentRoute = currentRoute(navController)
        items.forEach { navigation ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = navigation.icon), contentDescription = navigation.title, modifier = Modifier.size(24.dp)) },
                label = { Text(navigation.title) },
                selected = currentRoute == navigation.route,
                onClick = {
                    navController.navigate(navigation.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false, // Shows label only for the selected item
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController, items) }
    ) { innerPadding ->
        NavHost(navController, startDestination = Navigation.Home.route, modifier = Modifier.padding(innerPadding)) {
            composable(Navigation.Home.route) { /* Home Screen */ }
            composable(Navigation.Favorites.route) { /* Favorites Screen */ }
            composable(Navigation.Map.route) { /* Map Screen */ }
            composable(Navigation.Notifications.route) { /* Notifications Screen */ }
            composable(Navigation.Profile.route) { /* Profile Screen */ }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    AutoMobileTheme {
        AppNavigation()
    }
}