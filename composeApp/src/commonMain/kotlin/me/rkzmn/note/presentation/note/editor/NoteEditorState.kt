package me.rkzmn.note.presentation.note.editor

import androidx.compose.runtime.Immutable
import me.rkzmn.note.domain.note.Note

@Immutable
data class NoteEditorState(
    val noteTitle: String = "",
    val noteContent: String = "",
    val noteColor: Long = Note.generateRandomColor(),
    val isLoading: Boolean = false
)