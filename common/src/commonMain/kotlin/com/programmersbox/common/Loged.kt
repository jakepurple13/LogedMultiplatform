package com.programmersbox.common

/**
 * Created by Jacob on 10/3/17.
 */
public object Loged {
    /**
     * If there are any other classes that you do not want to show up
     */
    public var OTHER_CLASS_FILTER: (String) -> Boolean = { true }

    /**
     * Will pretty print all log messages if true
     */
    public var SHOW_PRETTY: Boolean = true

    /**
     * Will include the thread name in with the tag for all logs if true
     */
    public var WITH_THREAD_NAME: Boolean = true

    /**
     * Makes this the name of your package to prevent unwanted logs
     */
    @JvmStatic
    public var FILTER_BY_PACKAGE_NAME: String = ""

    /**
     * A log tag for all log messages using the [Loged] class
     * Default is "Loged"
     */
    @JvmStatic
    public var TAG: String = "Loged"

    /**
     * Enable this if you are unit testing. This will do a normal [println] instead of a [Log.println] if true
     */
    @JvmStatic
    public var UNIT_TESTING: Boolean = false

    /**
     * If you want to add an interceptor to add the logs to a certain location, make a class that implements [LogedInterceptor]
     */
    public var logedInterceptor: LogedInterceptor? = null

    /**
     * Converting the StackTraceElement into a string that will let us click straight to it
     */
    private val stackToString: StackTraceElement.() -> String =
        { "${className}.${methodName}(${fileName}:${lineNumber})" }

    /**
     * Filtering out the classes we do not want to see
     */
    private val filter: (StackTraceElement) -> Boolean = {
        !it.className.contains("Loged") && !it.className.contains("Framing") &&
                it.className.contains(FILTER_BY_PACKAGE_NAME) && OTHER_CLASS_FILTER(it.className)
    }

    /**
     * If you want to set the [OTHER_CLASS_FILTER] up via Higher-Order Functions
     */
    @Suppress("FunctionName")
    public fun OTHER_CLASS_FILTER(block: (String) -> Boolean) {
        OTHER_CLASS_FILTER = block
    }

    /**
     * If you want to add an interceptor to add the logs to a certain location, make a class that implements [LogedInterceptor]
     */
    public fun logedInterceptor(block: (level: LogLevel, tag: String, msg: String) -> Boolean) {
        logedInterceptor = LogedInterceptor { level, tag, msg -> block(level, tag, msg) }
    }

    /**
     * The show pretty method
     */
    private fun prettyLog(tag: String, msg: Any?, level: Int, threadName: Boolean) {
        val wanted = Thread.currentThread().stackTrace.filter(filter).map(stackToString)
            .let { it.mapIndexed { index, s -> "\n${if (index == 0) "╚" else "\t${if (index + 1 < it.size) '╠' else '╚'}"}═▷\t$s" } }
            .joinToString("")
        print(tag, "$msg$wanted", level, threadName)
    }

    /**
     * The not show pretty method
     */
    private fun log(tag: String, msg: Any?, level: Int, threadName: Boolean) {
        print(
            tag,
            "${msg.toString()}\n╚═▷\t${Thread.currentThread().stackTrace.firstOrNull(filter)?.stackToString()}",
            level,
            threadName
        )
    }

    /**
     * Actually printing to the console
     */
    private fun print(tag: String, msg: String, level: Int, threadName: Boolean) {
        if (UNIT_TESTING) println(msg) else printInfo(
            level,
            tag + if (threadName) "/${Thread.currentThread().name}" else "",
            msg
        )
    }

    /**
     * Delegating the showPretty or not
     */
    internal fun delegate(tag: String, msg: Any?, level: Int, threadName: Boolean, showPretty: Boolean = SHOW_PRETTY) {
        logedInterceptor?.log(LogLevel(level), tag, msg.toString())
            .let { if (it == false) return }
            .also { if (showPretty) prettyLog(tag, msg, level, threadName) else log(tag, msg, level, threadName) }
    }

}


public fun interface LogedInterceptor {
    /**
     * The log interceptor
     * @param level The level of the log.
     * @param tag The tag.
     * @param msg The msg.
     * @return true if you want the log to be printed to the console, false if you don't
     * @see LogLevel
     */
    public fun log(level: LogLevel, tag: String, msg: String): Boolean
}

internal expect fun printInfo(level: Int, threadName: String, msg: String)

public enum class LogLevel {
    WARN, ASSERT, INFO, VERBOSE, ERROR, DEBUG;

    public companion object {
        public operator fun invoke(level: Int): LogLevel = when (level) {
            2 -> WARN
            3 -> ASSERT
            4 -> INFO
            5 -> VERBOSE
            6 -> ERROR
            7 -> DEBUG
            else -> INFO
        }
    }
}