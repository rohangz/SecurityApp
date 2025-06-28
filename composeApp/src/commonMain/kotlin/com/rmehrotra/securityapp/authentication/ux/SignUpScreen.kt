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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.rmehrotra.securityapp.authentication.viewmodel.SignUpViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    onSignUpComplete: () -> Unit = {},
    viewModel: SignUpViewModel = koinViewModel<SignUpViewModel>()
) {
    val emailOrPhone by viewModel.emailOrPhone.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val confirmPassword by viewModel.confirmPassword.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Sign Up", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = emailOrPhone,
            onValueChange = viewModel::updateEmailOrPhone,
            label = { Text("Email") })
        OutlinedTextField(
            value = password,
            onValueChange = viewModel::updateConfirmPassword,
            label = { Text("Password") })
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = viewModel::updateConfirmPassword,
            label = { Text("Confirm Password") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onSignUpComplete) {
            Text("Sign Up")
        }
        TextButton(onClick = { navController.popBackStack() }) {
            Text("Already have an account? Sign In")
        }
    }
}