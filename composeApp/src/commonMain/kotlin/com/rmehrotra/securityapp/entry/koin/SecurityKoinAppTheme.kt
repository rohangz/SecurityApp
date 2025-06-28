package com.rmehrotra.securityapp.koin

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.koin.compose.KoinApplication

@Composable
fun SecurityKoinAppTheme(
    content: @Composable () -> Unit
) {
    KoinApplication(application = {
        initKoin()
    }) {
        MaterialTheme(
            content = content
        )
    }
}