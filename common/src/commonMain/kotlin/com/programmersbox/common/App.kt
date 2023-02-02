package com.programmersbox.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun App() {
    Loged.println1("Hello")
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(getPlatformName())
            }
        }
    }
}

private fun Loged.println1(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME,
): Unit = delegate(tag, msg, 4, threadName, showPretty)