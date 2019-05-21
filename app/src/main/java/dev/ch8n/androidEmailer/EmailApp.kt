package dev.ch8n.androidEmailer

import android.app.Application
import dev.ch8n.androidEmailer.injection.Injector
import timber.log.Timber

class EmailApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.getInstance()?.init(this)
        Timber.plant(Timber.DebugTree())
    }


}