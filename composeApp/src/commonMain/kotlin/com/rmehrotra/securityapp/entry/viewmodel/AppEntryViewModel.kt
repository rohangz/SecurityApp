package com.rmehrotra.securityapp.entry.viewmodel

import androidx.lifecycle.ViewModel
import com.rmehrotra.securityapp.entry.routes.EntryRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppEntryViewModel : ViewModel() {
    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn = _isUserLoggedIn.asStateFlow()

    private val _entryRoute = MutableStateFlow(EntryRoutes.Authentication.route)
    val entryRoute = _entryRoute.asStateFlow()

    fun updateUserLoggedInStatus(isLoggedIn: Boolean) {
        _isUserLoggedIn.value = isLoggedIn
        _entryRoute.value = getEntryRoute()
    }

    private fun getEntryRoute(): String {
        return if (_isUserLoggedIn.value) {
            EntryRoutes.Home.route
        } else {
            EntryRoutes.Authentication.route
        }
    }
}