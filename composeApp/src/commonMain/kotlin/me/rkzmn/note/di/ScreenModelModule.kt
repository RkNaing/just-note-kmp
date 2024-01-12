package me.rkzmn.note.di

import me.rkzmn.note.presentation.note.editor.NoteEditorScreenModel
import me.rkzmn.note.presentation.note.list.NoteListScreenModel
import org.koin.dsl.module

val screenModelsModule = module {
    factory { NoteListScreenModel(repository = get()) }
    factory { NoteEditorScreenModel(repository = get()) }
}