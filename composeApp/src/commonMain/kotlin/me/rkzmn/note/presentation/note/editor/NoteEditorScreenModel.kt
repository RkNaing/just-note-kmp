package me.rkzmn.note.presentation.note.editor

import cafe.adriel.voyager.core.model.ScreenModel
import me.rkzmn.note.domain.note.NotesRepository

class NoteEditorScreenModel(
    private val repository: NotesRepository
) : ScreenModel