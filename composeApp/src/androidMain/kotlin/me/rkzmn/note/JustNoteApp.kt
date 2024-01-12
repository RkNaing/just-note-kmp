package me.rkzmn.note

import android.app.Application
import me.rkzmn.note.di.setupKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class JustNoteApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin {
            androidContext(this@JustNoteApp)
            androidLogger(level = Level.DEBUG)
        }
    }
}