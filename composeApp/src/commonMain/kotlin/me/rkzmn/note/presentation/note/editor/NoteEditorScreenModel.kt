package me.rkzmn.note.presentation.note.editor

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.domain.note.NotesRepository
import me.rkzmn.note.presentation.note.list.NoteListState
import me.rkzmn.note.utils.kotlin.now
import org.koin.core.parameter.parametersOf

class NoteEditorScreenModel(
    private val repository: NotesRepository,
    private val noteId: Long
) : ScreenModel {

    private val _editorState = MutableStateFlow(NoteEditorState())
    val editorState = _editorState.asStateFlow()

    private var originalNote: Note? = null

    init {
        loadNote()
    }

    fun saveNote() {
        _editorState.update { it.copy(isLoading = true) }
        val state = _editorState.value

        if (noteId < 1L && with(state){ noteTitle.isEmpty() && noteContent.isEmpty()}){
            return
        }

        screenModelScope.launch {
            repository.saveNote(
                Note(
                    id = originalNote?.id ?: 0L,
                    title = state.noteTitle,
                    content = state.noteContent,
                    colorHex = state.noteColor,
                    created = originalNote?.created ?: LocalDateTime.now()
                )
            )
        }
    }

    fun onTitleChanged(title: String) {
        _editorState.update { it.copy(noteTitle = title) }
    }

    fun onContentChanged(content: String) {
        _editorState.update { it.copy(noteContent = content) }
    }

    private fun loadNote() {
        if (noteId < 1L) {
            return
        }

        screenModelScope.launch {
            _editorState.update { it.copy(isLoading = true) }
            val note = repository.getNoteById(id = noteId) ?: return@launch
            originalNote = note
            _editorState.update {
                it.copy(
                    noteTitle = note.title,
                    noteContent = note.content,
                    noteColor = note.colorHex,
                    isLoading = false
                )
            }
        }
    }

}