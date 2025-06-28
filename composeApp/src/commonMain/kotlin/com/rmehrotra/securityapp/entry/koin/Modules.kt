package com.rmehrotra.securityapp.koin

import com.rmehrotra.securityapp.HelloService
import com.rmehrotra.securityapp.HelloViewModel
import org.koin.dsl.module

val appModule = module {
    single { HelloService() }
    single { HelloViewModel(get()) }
}