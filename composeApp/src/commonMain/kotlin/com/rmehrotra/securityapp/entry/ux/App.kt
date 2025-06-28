package com.rmehrotra.securityapp.entry.ux

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rmehrotra.securityapp.Greeting
import com.rmehrotra.securityapp.authentication.ux.AuthScreen
import com.rmehrotra.securityapp.entry.koin.SecurityKoinAppTheme
import com.rmehrotra.securityapp.entry.routes.EntryRoutes
import com.rmehrotra.securityapp.entry.viewmodel.AppEntryViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import securityapp.composeapp.generated.resources.Res
import securityapp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    SecurityKoinAppTheme {
        val navController = rememberNavController()
        val viewModel = koinInject<AppEntryViewModel>()
        val entryRoute by viewModel.entryRoute.collectAsStateWithLifecycle()
        NavHost(navController = navController, startDestination = entryRoute) {
            composable(EntryRoutes.Authentication.route) {
                AuthScreen(
                    onSignUpComplete = { viewModel.updateUserLoggedInStatus(true) },
                    onLoginComplete = { viewModel.updateUserLoggedInStatus(true) })
            }
            composable(EntryRoutes.Home.route) {
                HomeScreen()
            }
        }
    }
}