package com.rmehrotra.securityapp.authentication.koin

import com.rmehrotra.securityapp.authentication.viewmodel.SignInViewModel
import com.rmehrotra.securityapp.authentication.viewmodel.SignUpViewModel
import org.koin.dsl.module

val authAppModule = module {
    factory { SignInViewModel() }
    factory { SignUpViewModel() }
}