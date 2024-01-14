package me.rkzmn.note.presentation.note.list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import me.rkzmn.note.domain.note.Note

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesList(
    modifier: Modifier = Modifier,
    notes: ImmutableList<Note>,
    onClickNoteItem: (Note) -> Unit,
    onClickDeleteNote: (Note) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = notes,
            key = {note -> note.id}
        ){note ->
            NoteListItem(
                note = note,
                onClickedNote = onClickNoteItem,
                onClickedDelete = onClickDeleteNote,
                modifier = Modifier.fillMaxWidth().animateItemPlacement()
            )
        }
    }
}