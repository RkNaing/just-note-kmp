package me.rkzmn.note.presentation.note.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.utils.kotlin.format

@Composable
fun NoteListItem(
    note: Note,
    onClickedNote: (Note) -> Unit,
    onClickedDelete: (Note) -> Unit,
    modifier: Modifier = Modifier
) {
    val formattedDate = remember(note.created) { note.created.format() }
    val backgroundColor = remember(note.colorHex) { Color(note.colorHex) }

    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .background(color = backgroundColor)
            .clickable { onClickedNote(note) }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = note.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )

            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Delete Note",
                tint = Color.Black,
                modifier = Modifier.clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = { onClickedDelete(note) }
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = note.content,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = formattedDate,
            modifier = Modifier.align(alignment = Alignment.End),
            style = MaterialTheme.typography.labelMedium,
            color = Color.DarkGray
        )
    }
}