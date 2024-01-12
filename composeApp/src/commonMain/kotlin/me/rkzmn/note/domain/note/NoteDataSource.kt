package me.rkzmn.note.domain.note

import kotlinx.coroutines.flow.Flow

interface NoteDataSource {
    suspend fun saveNote(note: Note)

    suspend fun getNoteById(id: Long): Note?

    fun getAllNotes(): Flow<List<Note>>

    suspend fun deleteNoteById(id: Long)

    fun searchNotes(query: String): Flow<List<Note>>
}