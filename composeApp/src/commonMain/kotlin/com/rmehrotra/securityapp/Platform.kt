package com.rmehrotra.securityapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform