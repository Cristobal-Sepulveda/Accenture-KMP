package com.example.kmp_example

import com.example.kmp_example.di.appModule
import org.koin.core.context.startKoin

fun InitKoin() {
    startKoin {
        modules(appModule())
    }
}
