package com.br.wcabral.kotlin.android.githubcompose

import android.app.Application
import com.br.wcabral.kotlin.android.githubcompose.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GithubApplication)
            modules(appModules)
        }
    }

}
