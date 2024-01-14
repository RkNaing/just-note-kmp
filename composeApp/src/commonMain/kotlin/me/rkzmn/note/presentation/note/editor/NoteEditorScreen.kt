package me.rkzmn.note.presentation.note.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.rkzmn.note.presentation.components.TransparentHintTextField
import me.rkzmn.note.presentation.note.list.NoteListScreenModel
import org.koin.core.parameter.parametersOf

class NoteEditorScreen(private val noteId: Long = 0L) : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<NoteEditorScreenModel> { parametersOf(noteId) }
        val navigator = LocalNavigator.currentOrThrow

        val editorState by screenModel.editorState.collectAsState()

        LifecycleEffect(
            onDisposed = { screenModel.saveNote() }
        )

        NoteEditorScreenContent(
            state = editorState,
            onTitleChanged = { screenModel.onTitleChanged(it) },
            onContentChanged = { screenModel.onContentChanged(it) },
            onExit = { navigator.pop() }
        )

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NoteEditorScreenContent(
        state: NoteEditorState,
        onTitleChanged: (String) -> Unit,
        onContentChanged: (String) -> Unit,
        onExit: () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = { Text(text = "Note Editor") },
                    navigationIcon = {
                        IconButton(onClick = onExit) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Exit Note Editor"
                            )
                        }
                    }
                )
            }
        ) { contentPadding ->
            Surface(modifier = Modifier.fillMaxSize().padding(contentPadding)) {
                NoteEditor(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onTitleChanged = onTitleChanged,
                    titleHint = "Note Title...",
                    onContentChanged = onContentChanged,
                    contentHint = "Note..."
                )
            }
        }
    }

    @Composable
    fun NoteEditor(
        modifier: Modifier = Modifier,
        state: NoteEditorState,
        onTitleChanged: (String) -> Unit,
        titleHint: String = "",
        onContentChanged: (String) -> Unit,
        contentHint: String = ""
    ) {
        Column(
            modifier = Modifier.background(Color(state.noteColor)).then(modifier)
        ) {

            if (state.isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            TransparentHintTextField(
                text = state.noteTitle,
                hint = titleHint,
                enabled = !state.isLoading,
                onValueChanged = onTitleChanged,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.titleMedium,
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TransparentHintTextField(
                text = state.noteContent,
                hint = contentHint,
                enabled = !state.isLoading,
                onValueChanged = onContentChanged,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                textStyle = MaterialTheme.typography.bodyMedium,
                singleLine = false
            )
        }
    }
}