package levi.lin.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import levi.lin.app.app.App
import levi.lin.app.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookApp",
        ) {
            App()
        }
    }
}