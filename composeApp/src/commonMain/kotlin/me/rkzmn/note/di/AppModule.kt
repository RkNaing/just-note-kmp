package me.rkzmn.note.di

import me.rkzmn.note.data.SqlDelightNoteDataSource
import me.rkzmn.note.data.local.DatabaseDriverFactory
import me.rkzmn.note.db.NotesDatabase
import me.rkzmn.note.domain.note.NoteDataSource
import me.rkzmn.note.utils.kotlin.CoroutineDispatchers
import org.koin.dsl.module

val appModule = module {
    single { createNotesDatabase(driverFactory = get()) }
    single<NoteDataSource> {
        SqlDelightNoteDataSource(
            database = get(),
            dispatchers = get()
        )
    }
    single { CoroutineDispatchers() }
}

private fun createNotesDatabase(
    driverFactory: DatabaseDriverFactory
): NotesDatabase = NotesDatabase(driver = driverFactory.createDriver())