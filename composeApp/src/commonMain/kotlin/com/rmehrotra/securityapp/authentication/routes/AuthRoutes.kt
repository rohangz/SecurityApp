package com.rmehrotra.securityapp.authentication.routes

sealed class AuthRoutes(val route: String) {
    object Login : AuthRoutes("login")
    object SignUp : AuthRoutes("signup")
}
