package me.rkzmn.note.di

import me.rkzmn.note.data.local.DatabaseDriverFactory
import org.koin.dsl.module

actual val platformModule = module {
    single { DatabaseDriverFactory() }
}