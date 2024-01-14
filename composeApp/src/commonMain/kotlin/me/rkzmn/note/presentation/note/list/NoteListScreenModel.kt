package me.rkzmn.note.presentation.note.list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.domain.note.NotesRepository

class NoteListScreenModel(
    private val repository: NotesRepository
) : ScreenModel {

//    private val _notesState = MutableStateFlow(NoteListState())
//    val notesState = _notesState.asStateFlow()

    val notes = repository.getAllNotes()
        .map { it.toPersistentList() }
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000L),
            initialValue = persistentListOf()
        )

    init {
//        loadNotes()
    }

//    private fun loadNotes() {
//
//        screenModelScope.launch {
//            repository.getAllNotes().collectLatest { notes ->
//                _notesState.update { it.copy(notes = notes.toImmutableList()) }
//            }
//        }
//    }

    fun onSearchQueryChanged(query: String) {

    }

    fun onToggleSearch() {

    }

    fun deleteNote(note: Note) {
        screenModelScope.launch {
            repository.deleteNoteById(id = note.id)
        }
    }
}