package com.br.wcabral.kotlin.android.githubcompose.di

import com.br.wcabral.kotlin.android.githubcompose.data.GithubApi
import com.br.wcabral.kotlin.android.githubcompose.data.Endpoints
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(GithubApi::class.java)
    }

}

val appModules = listOf(
    appModule,
    repositoryModule,
    viewModelModule
)
