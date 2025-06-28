package com.rmehrotra.securityapp.authentication.ux

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.rmehrotra.securityapp.authentication.routes.AuthRoutes
import com.rmehrotra.securityapp.authentication.viewmodel.SignInViewModel
import com.rmehrotra.securityapp.authentication.viewmodel.SignUpViewModel
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun SignInScreen(
    navController: NavController,
    onLoginComplete: () -> Unit = {},
    viewModel: SignInViewModel = koinViewModel<SignInViewModel>()
) {
    val emailOrPhone by viewModel.emailOrPhone.collectAsStateWithLifecycle()
    val passwordOrOtp by viewModel.passwordOrOtp.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Sign In", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = emailOrPhone,
            onValueChange = viewModel::onUpdateEmailOrPhone,
            label = { Text("Email") })
        OutlinedTextField(
            value = passwordOrOtp,
            onValueChange = viewModel::onUpdatePasswordOrOtp,
            label = { Text("Password") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onLoginComplete) {
            Text("Sign In")
        }
        TextButton(onClick = { navController.navigate(AuthRoutes.SignUp.route) }) {
            Text("Don’t have an account? Sign Up")
        }
    }
}