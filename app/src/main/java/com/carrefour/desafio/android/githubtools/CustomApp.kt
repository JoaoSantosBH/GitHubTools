package com.carrefour.desafio.android.githubtools

import android.app.Application
import com.carrefour.desafio.android.githubtools.core.di.mainModule
import com.carrefour.desafio.android.githubtools.features.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class CustomApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        val modules = mutableListOf(
            mainModule,homeModule

        )
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@CustomApp)
            modules(modules)
        }
    }
}