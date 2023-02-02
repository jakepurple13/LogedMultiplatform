import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.programmersbox.common.Loged
import com.programmersbox.common.UIShow
import com.programmersbox.common.println

fun main() = application {
    Loged.println("Hello!")
    Window(onCloseRequest = ::exitApplication) {
        UIShow()
    }
}
