package com.rmehrotra.securityapp.entry.koin

import com.rmehrotra.securityapp.authentication.koin.authAppModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            appModule,
            authAppModule
        )
    }
}