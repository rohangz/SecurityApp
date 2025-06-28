package com.rmehrotra.securityapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rmehrotra.securityapp.entry.ux.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "securityapp",
    ) {
        App()
    }
}