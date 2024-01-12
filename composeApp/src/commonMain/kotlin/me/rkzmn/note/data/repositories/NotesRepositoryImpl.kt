package me.rkzmn.note.data.repositories

import kotlinx.coroutines.flow.Flow
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.domain.note.NoteDataSource
import me.rkzmn.note.domain.note.NotesRepository

class NotesRepositoryImpl(
    private val dataSource: NoteDataSource
): NotesRepository {

    override suspend fun saveNote(note: Note) {
        dataSource.saveNote(note)
    }

    override suspend fun getNoteById(id: Long): Note? {
        return dataSource.getNoteById(id)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return dataSource.getAllNotes()
    }

    override suspend fun deleteNoteById(id: Long) {
        return dataSource.deleteNoteById(id)
    }

    override fun searchNotes(query: String): Flow<List<Note>> {
        return dataSource.searchNotes(query)
    }
}