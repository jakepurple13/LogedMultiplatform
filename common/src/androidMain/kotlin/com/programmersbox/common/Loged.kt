package com.programmersbox.common

import android.util.Log

internal actual fun printInfo(level: Int, threadName: String, msg: String) {
    Log.println(level, threadName, msg)
}

/**
 * Error log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.e(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.ERROR, threadName, showPretty)

/**
 * Info log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.i(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.INFO, threadName, showPretty)

/**
 * Assert log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.a(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.ASSERT, threadName, showPretty)

/**
 * What a Terrible Failure log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.wtf(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.ASSERT, threadName, showPretty)

/**
 * Warning log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.w(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.WARN, threadName, showPretty)

/**
 * Debug log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.d(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.DEBUG, threadName, showPretty)

/**
 * Verbose log
 *
 * @param msg the message to log
 */
@JvmOverloads
public fun Loged.v(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME
): Unit = delegate(tag, msg, Log.VERBOSE, threadName, showPretty)

/**
 * Random log
 *
 * @param msg the message to log
 * @param choices the different priority levels. MUST be between 2-7
 *  ### [Log.VERBOSE] = 2
 *  ### [Log.DEBUG] = 3
 *  ### [Log.INFO] = 4
 *  ### [Log.WARN] = 5
 *  ### [Log.ERROR] = 6
 *  ### [Log.ASSERT] = 7
 */
@JvmOverloads
public fun Loged.r(
    msg: Any? = null,
    tag: String = TAG,
    showPretty: Boolean = SHOW_PRETTY,
    threadName: Boolean = WITH_THREAD_NAME,
    vararg choices: Int = intArrayOf(2, 3, 4, 5, 6, 7)
): Unit = delegate(tag, msg, choices.random().let { if (it in 2..7) it else (2..7).random() }, threadName, showPretty)

@JvmOverloads
public fun Loged.fv(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 2)

@JvmOverloads
public fun Loged.fd(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 3)

@JvmOverloads
public fun Loged.fi(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 4)

@JvmOverloads
public fun Loged.fw(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 5)

@JvmOverloads
public fun Loged.fe(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 6)

@JvmOverloads
public fun Loged.fa(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 7)

//----------------------------
@JvmOverloads
public fun Loged.fv(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 2)

@JvmOverloads
public fun Loged.fd(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 3)

@JvmOverloads
public fun Loged.fi(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 4)

@JvmOverloads
public fun Loged.fw(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 5)

@JvmOverloads
public fun Loged.fe(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 6)

@JvmOverloads
public fun Loged.fa(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠")
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 7)

//----------------
public fun <T> Loged.fv(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"), transform: (T) -> String = { it.toString() }
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 2, transform = transform)

public fun <T> Loged.fd(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"), transform: (T) -> String = { it.toString() }
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 3, transform = transform)

public fun <T> Loged.fi(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"), transform: (T) -> String = { it.toString() }
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 4, transform = transform)

public fun <T> Loged.fw(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"), transform: (T) -> String = { it.toString() }
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 5, transform = transform)

public fun <T> Loged.fe(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"), transform: (T) -> String = { it.toString() }
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 6, transform = transform)

public fun <T> Loged.fa(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"), transform: (T) -> String = { it.toString() }
): Unit = Loged.f(msg, tag, infoText, showPretty, threadName, frameType, 7, transform = transform)

/**
 * [Loged.r] but adds a frame around the [msg] using the [String.frame] method
 */
@JvmOverloads
public fun Loged.f(
    msg: Any? = null,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"),
    vararg choices: Int = intArrayOf(2, 3, 4, 5, 6, 7)
): Unit = r(
    "${if (UNIT_TESTING) "" else "$infoText\n"}${msg.toString().frame(frameType.copy(top = tag))}",
    tag,
    showPretty,
    threadName,
    *choices
)

/**
 * [Loged.r] but adds a frame around the [msg] using the [Iterable.frame] method
 */
public fun Loged.f(
    msg: Iterable<*>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"),
    vararg choices: Int = intArrayOf(2, 3, 4, 5, 6, 7)
): Unit = r(
    "${if (UNIT_TESTING) "" else "$infoText\n"}${msg.frame(frameType.copy(top = tag))}",
    tag,
    showPretty,
    threadName,
    *choices
)

/**
 * [Loged.r] but adds a frame around the [msg] using the [Iterable.frame] method. Also allows you to [transform] the objects if you wish, otherwise
 * [toString] will be called
 */
public fun <T> Loged.f(
    msg: Iterable<T>,
    tag: String = TAG, infoText: String = TAG,
    showPretty: Boolean = SHOW_PRETTY, threadName: Boolean = WITH_THREAD_NAME,
    frameType: FrameType = defaultFrameType.copy(bottomLeft = "╠"),
    vararg choices: Int = intArrayOf(2, 3, 4, 5, 6, 7), transform: (T) -> String = { it.toString() }
): Unit = r(
    "${if (UNIT_TESTING) "" else "$infoText\n"}${msg.frame(frameType.copy(top = tag), transform = transform)}",
    tag, showPretty, threadName, *choices
)