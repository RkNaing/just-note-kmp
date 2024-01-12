package me.rkzmn.note.presentation.note.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.rkzmn.note.presentation.note.list.components.NotesList

class NoteListScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<NoteListScreenModel>()
        val navigator = LocalNavigator.currentOrThrow

        val state by screenModel.notesState.collectAsState()

        NotesListScreenContent(state = state)
    }

    @Composable
    fun NotesListScreenContent(
        state: NoteListState
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {

            }
        ) { contentPadding ->

            NotesList(
                modifier = Modifier.padding(contentPadding).fillMaxSize(),
                notes = state.notes,
                onClickDeleteNote = {},
                onClickNoteItem = {}
            )

        }
    }

}