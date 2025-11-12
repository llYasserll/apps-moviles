package com.example.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.test.ui.screens.SplashScreen
import com.example.test.ui.screens.LoginScreen
import com.example.test.ui.screens.RegisterScreen
import com.example.test.ui.screens.ForgotPasswordScreen
import com.example.test.ui.onboarding.screens.OnboardingScreen
import com.example.test.ui.onboarding.screens.TrackingScreen
import com.example.test.ui.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        //composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("forgot_password") {
            ForgotPasswordScreen(navController)
        }
        composable("register") {
            RegisterScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }

        composable("onboarding") {
            OnboardingScreen(
                onNext = { navController.navigate("login") }
            )
        }

        composable(
            "tracking/{cafeName}",
            arguments = listOf(navArgument("cafeName") { type = NavType.StringType })
        ) { backStackEntry ->
            val cafeName = backStackEntry.arguments?.getString("cafeName") ?: ""
            TrackingScreen(cafeName = cafeName)
        }
    }
}
