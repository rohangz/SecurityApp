package com.rmehrotra.securityapp.entry.koin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.KoinApplication

@Composable
fun SecurityKoinAppTheme(
    content: @Composable () -> Unit
) {
    KoinApplication(application = {
        initKoin()
    }) {
        MaterialTheme {
            Column(modifier = Modifier.fillMaxSize().safeContentPadding()) {
                content()
            }
        }
    }
}