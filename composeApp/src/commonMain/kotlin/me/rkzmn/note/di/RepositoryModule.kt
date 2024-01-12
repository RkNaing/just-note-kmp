package me.rkzmn.note.di

import me.rkzmn.note.data.repositories.NotesRepositoryImpl
import me.rkzmn.note.domain.note.NotesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<NotesRepository> { NotesRepositoryImpl(dataSource = get()) }
}