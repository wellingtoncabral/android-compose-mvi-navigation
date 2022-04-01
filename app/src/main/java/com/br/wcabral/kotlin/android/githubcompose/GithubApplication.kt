package com.br.wcabral.kotlin.android.githubcompose

import android.app.Application
import com.br.wcabral.kotlin.android.githubcompose.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GithubApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GithubApplication)
            modules(appModules)
        }
    }

}
