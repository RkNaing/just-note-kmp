package me.rkzmn.note.presentation.note.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import me.rkzmn.note.domain.note.Note
import me.rkzmn.note.presentation.note.editor.NoteEditorScreen
import me.rkzmn.note.presentation.note.list.components.NotesEmptyView
import me.rkzmn.note.presentation.note.list.components.NotesList

class NoteListScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<NoteListScreenModel>()
        val navigator = LocalNavigator.currentOrThrow

        val state by screenModel.notes.collectAsState()

        LifecycleEffect(
            onStarted = { println("NoteListScreen : Shown") },
            onDisposed = { println("NoteListScreen : Disposed") }
        )

        NotesListScreenContent(
            notes = state,
            onClickNoteItem = { note -> navigator.push(NoteEditorScreen(noteId = note.id)) },
            onClickDeleteNote = { note -> screenModel.deleteNote(note)},
            onClickCreateNote = {
                navigator.push(NoteEditorScreen())
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NotesListScreenContent(
        notes: ImmutableList<Note>,
        onClickNoteItem: (Note) -> Unit,
        onClickDeleteNote: (Note) -> Unit,
        onClickCreateNote: () -> Unit
    ) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

        Scaffold(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = { Text(text = "Notes") },
                    scrollBehavior = scrollBehavior
                )
            },
            floatingActionButton = { CreateNoteButton(onClick = onClickCreateNote) }
        ) { contentPadding ->

            val showEmptyView by remember {
                derivedStateOf {
                    notes.isEmpty()
                }
            }

            Box(
                modifier = Modifier.padding(contentPadding).fillMaxSize()
            ) {
                if (showEmptyView) {
                    NotesEmptyView(
                        modifier = Modifier.fillMaxSize(),
                        message = "No notes yet... create a note by clicking +."
                    )
                } else {
                    NotesList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        notes = notes,
                        onClickDeleteNote = onClickDeleteNote,
                        onClickNoteItem = onClickNoteItem
                    )
                }
            }


        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Toolbar(
        modifier: Modifier
    ) {
        TopAppBar(
            modifier = modifier,
            title = { Text(text = "Notes") },
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
        )
    }

    @Composable
    fun CreateNoteButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        FloatingActionButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Create Note"
            )
        }
    }

}