package me.rkzmn.note.data

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import me.rkzmn.note.db.NotesDatabase
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.domain.note.NoteDataSource
import me.rkzmn.note.domain.note.asNote
import me.rkzmn.note.domain.note.createNoteInstance
import me.rkzmn.note.utils.kotlin.CoroutineDispatchers
import me.rkzmn.note.utils.kotlin.toEpochMillis

class SqlDelightNoteDataSource(
    database: NotesDatabase,
    private val dispatchers: CoroutineDispatchers,
) : NoteDataSource {

    private val queries = database.noteQueries

    override suspend fun saveNote(note: Note) {
        withContext(dispatchers.io) {
            with(note) {
                queries.saveNote(
                    id = id.takeIf { it > 0L },
                    title = title,
                    content = content,
                    colorHex = colorHex,
                    created = created.toEpochMillis()
                )
            }
        }
    }

    override suspend fun getNoteById(id: Long): Note? = withContext(dispatchers.io) {
        queries.getNoteById(id = id).executeAsOneOrNull()?.asNote()
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return queries
            .getAllNotes(mapper = ::createNoteInstance)
            .flow
    }

    override suspend fun deleteNoteById(id: Long) = withContext(dispatchers.io) {
        queries.deleteNoteById(id = id)
    }

    override fun searchNotes(query: String): Flow<List<Note>> {
        return queries.searchNotes(
            query = query,
            mapper = ::createNoteInstance
        ).flow
    }

    private val Query<Note>.flow: Flow<List<Note>>
        get() = asFlow().mapToList(dispatchers.io).flowOn(dispatchers.io)

}