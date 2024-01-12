package me.rkzmn.note

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import me.rkzmn.note.presentation.note.list.NoteListScreen
import me.rkzmn.note.presentation.ui.ThemedContent

@Composable
fun App() {

    ThemedContent {
        Navigator(screen = NoteListScreen())
    }
//    MaterialTheme {
//    }
}