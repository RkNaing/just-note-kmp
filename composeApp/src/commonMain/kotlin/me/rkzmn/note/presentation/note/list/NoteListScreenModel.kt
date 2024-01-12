package me.rkzmn.note.presentation.note.list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.domain.note.NotesRepository
import me.rkzmn.note.utils.kotlin.now

class NoteListScreenModel(
    private val repository: NotesRepository
) : ScreenModel {

    private val _notesState = MutableStateFlow(NoteListState())
    val notesState = _notesState.asStateFlow()

    init {
        loadNotes()
    }

    private fun loadNotes() {
        screenModelScope.launch {
//            repository.getAllNotes().collectLatest { notes ->
//                _notesState.update { it.copy(notes = notes.toImmutableList()) }
//            }
            _notesState.update { it.copy(notes = createDummyNotes().toImmutableList()) }
        }
    }

    fun onSearchQueryChanged(query: String) {

    }

    fun onToggleSearch() {

    }

    fun deleteNoteById(id: Long) {

    }

    private fun createDummyNotes(): List<Note> {
        return (1..100).map { index ->
            Note(
                id = index.toLong(),
                title = "Note #$index",
                content = "Content of Note #$index",
                colorHex = Note.generateRandomColor(),
                created = LocalDateTime.now()
            )
        }
    }

}