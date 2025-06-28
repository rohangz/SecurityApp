package com.rmehrotra.securityapp.entry.koin

import com.rmehrotra.securityapp.entry.viewmodel.AppEntryViewModel
import org.koin.dsl.module

val appModule = module {
    factory { AppEntryViewModel() }
}