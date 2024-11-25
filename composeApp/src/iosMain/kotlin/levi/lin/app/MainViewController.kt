package levi.lin.app

import androidx.compose.ui.window.ComposeUIViewController
import levi.lin.app.app.App
import levi.lin.app.di.initKoin

fun mainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }