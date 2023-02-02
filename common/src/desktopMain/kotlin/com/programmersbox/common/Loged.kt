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
