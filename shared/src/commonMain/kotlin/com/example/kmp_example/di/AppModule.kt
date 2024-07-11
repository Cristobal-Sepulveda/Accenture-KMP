package com.example.kmp_example.di

import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf
import com.example.kmp_example.presentation.viewmodels.HomeViewModel

val sharedModule = module {
    factoryOf(::HomeViewModel)

}

fun appModule() = listOf(sharedModule)