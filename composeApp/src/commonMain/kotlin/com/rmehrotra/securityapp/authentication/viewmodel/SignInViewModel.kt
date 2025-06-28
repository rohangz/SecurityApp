package com.rmehrotra.securityapp.authentication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel : ViewModel() {
    private val _emailOrPhone = MutableStateFlow("")
    val emailOrPhone = _emailOrPhone.asStateFlow()

    private val _passwordOrOtp = MutableStateFlow("")
    val passwordOrOtp = _passwordOrOtp.asStateFlow()

    fun onUpdateEmailOrPhone(value: String) {
        _emailOrPhone.value = value
    }

    fun onUpdatePasswordOrOtp(value: String) {
        _passwordOrOtp.value = value
    }

    fun onSignIn() {

    }
}