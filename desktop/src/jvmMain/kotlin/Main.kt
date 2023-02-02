import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.programmersbox.common.Loged
import com.programmersbox.common.UIShow
import com.programmersbox.common.framedPrintln
import com.programmersbox.common.println

fun main() = application {
    Loged.FILTER_BY_PACKAGE_NAME = "programmersbox"
    Loged.println("Hello!")
    Loged.framedPrintln("Hello!")
    Loged.framedPrintln("Hello!".repeat(100))
    Loged
    Window(onCloseRequest = ::exitApplication) {
        UIShow()
    }
}

/*fun main() {
    Loged.println("Hello World!")
}*/
