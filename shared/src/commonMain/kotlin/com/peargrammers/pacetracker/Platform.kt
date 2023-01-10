package com.peargrammers.pacetracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform