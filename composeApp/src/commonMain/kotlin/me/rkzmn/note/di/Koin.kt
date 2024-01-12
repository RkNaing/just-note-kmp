package me.rkzmn.note.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun setupKoin(
    additionalSetup: KoinApplication.() -> Unit = {}
) {
    startKoin {
        additionalSetup()
        modules(
            platformModule,
            appModule,
            repositoryModule,
            screenModelsModule
        )
    }
}

fun setupKoinIOS() {
    setupKoin()
}