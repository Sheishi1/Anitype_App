package com.example.anitype_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform