import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.rkzmn.note.App
import me.rkzmn.note.di.setupKoin

fun main() = application {
    setupKoin()
    Window(onCloseRequest = ::exitApplication, title = "JustNote") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}