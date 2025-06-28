package com.rmehrotra.securityapp.authentication.ux

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rmehrotra.securityapp.authentication.routes.AuthRoutes

@Composable
fun AuthScreen(
    onLoginComplete: () -> Unit = {},
    onSignUpComplete: () -> Unit = {},
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AuthRoutes.Login.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(AuthRoutes.Login.route) {
            SignInScreen(
                navController = navController,
                onLoginComplete = onLoginComplete,
            )
        }
        composable(route = AuthRoutes.SignUp.route) {
            SignUpScreen(
                navController = navController,
                onSignUpComplete = onSignUpComplete,
            )
        }
    }
}