package com.badista.movieskmm.android

import android.app.Application
import com.badista.movieskmm.android.di.appModule
import com.badista.movieskmm.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}