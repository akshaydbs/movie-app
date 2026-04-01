package com.development.movieapplication

import android.app.Application
import com.development.movie.data.di.movieModule
import com.development.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApplication)

            modules(
                networkModule,movieModule
            )
        }
    }
}