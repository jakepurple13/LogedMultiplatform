package com.programmersbox.android

import android.app.Application

class LogedApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            e.printStackTrace()
        }
    }
}