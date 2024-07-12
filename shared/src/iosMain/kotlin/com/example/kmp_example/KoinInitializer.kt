package com.example.kmp_example

import com.example.kmp_example.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class KoinInitializer : KoinComponent {
    fun initKoin() {
        startKoin {
            modules(appModule())
        }
    }
}