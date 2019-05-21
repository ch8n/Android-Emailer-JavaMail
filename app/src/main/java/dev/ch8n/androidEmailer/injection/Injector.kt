package dev.ch8n.androidEmailer.injection

import android.content.Context

class Injector private constructor() {

    lateinit var appContext: Context

    fun init(context: Context) {
        appContext = context.applicationContext
    }

    companion object {

        @Volatile
        private var instance: Injector? = null

        @Synchronized
        fun getInstance(): Injector? = if (instance == null) {
            Injector().also { instance = it }
        } else {
            instance
        }


    }
}