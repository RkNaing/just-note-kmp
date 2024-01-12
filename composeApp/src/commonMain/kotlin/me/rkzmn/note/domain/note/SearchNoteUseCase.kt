package me.rkzmn.note.domain.note

class SearchNoteUseCase {

    fun execute(
        notes: List<Note>,
        query: String
    ): List<Note> {
        if (query.isBlank()) return notes

        return notes.filter {note ->
            matchesSearch(query = query, target = note.title) ||
                    matchesSearch(query = query, target = note.content)
        }.sortedBy(Note::created)
    }

    private fun matchesSearch(query: String, target: String): Boolean {
        return target.trim().lowercase().contains(query.trim().lowercase())
    }
}