package com.example.okhttp.Model

import android.app.Application
import android.content.Context

class SingletonContext : Application() {
    init {
        instance = this
    }

    companion object {
        var instance: SingletonContext? = null

        fun applicationContext(): Context? {
            return instance!!.applicationContext
        }
    }
}