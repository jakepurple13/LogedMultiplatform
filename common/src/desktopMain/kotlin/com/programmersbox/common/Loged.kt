package com.programmersbox.common

internal actual fun printInfo(level: Int, threadName: String, msg: String) {
    println("${LogLevel(level)}/$threadName/ $msg")
}

@JvmOverloads
public fun Loged.println(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME,
): Unit = delegate(tag, msg, 4, threadName, showPretty)

/**
 * [Loged.println] but adds a frame around the [msg] using the [String.frame] method
 */
@JvmOverloads
public fun Loged.framedPrintln(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"),
): Unit = delegate( //call println
    tag,
    "${if (UNIT_TESTING) "" else "$infoText\n"}${msg.toString().frame(frameType.copy(top = tag))}",
    4,
    threadName,
    showPretty,
)