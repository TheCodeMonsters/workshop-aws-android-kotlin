package com.manuelduarte077.awskotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manuelduarte077.awskotlin.screens.HomeScreen
import com.manuelduarte077.awskotlin.screens.LoginScreen
import com.manuelduarte077.awskotlin.screens.SignUpScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
    }

}

