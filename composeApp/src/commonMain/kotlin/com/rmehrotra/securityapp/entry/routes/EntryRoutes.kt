package com.rmehrotra.securityapp.entry.routes

sealed class EntryRoutes(val route: String) {
    object Authentication : EntryRoutes("authentication")
    object Home : EntryRoutes("home")
}