package me.rkzmn.note.domain.note

import kotlinx.datetime.LocalDateTime
import me.rkzmn.note.db.NoteEntity
import me.rkzmn.note.utils.kotlin.from

fun NoteEntity.asNote(): Note = Note(
    id = id,
    title = title,
    content = content,
    colorHex = colorHex,
    created = LocalDateTime.from(epochMillis = created)
)

fun createNoteInstance(
    id: Long,
    title: String,
    content: String,
    colorHex: Long,
    createdEpochMillis: Long
): Note = Note(
    id = id,
    title = title,
    content = content,
    colorHex = colorHex,
    created = LocalDateTime.from(epochMillis = createdEpochMillis)
)