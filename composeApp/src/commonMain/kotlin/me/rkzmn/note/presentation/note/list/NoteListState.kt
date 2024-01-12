package me.rkzmn.note.presentation.note.list

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import me.rkzmn.note.domain.note.Note

@Immutable
data class NoteListState(
    val notes: ImmutableList<Note> = persistentListOf(),
    val searchQuery: String = "",
    val isSearchActive: Boolean = false
)
