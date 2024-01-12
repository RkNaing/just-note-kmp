package me.rkzmn.note.domain.note

import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    suspend fun saveNote(note: Note)

    suspend fun getNoteById(id: Long): Note?

    fun getAllNotes(): Flow<List<Note>>

    suspend fun deleteNoteById(id: Long)

    fun searchNotes(query: String): Flow<List<Note>>

}