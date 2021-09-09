package com.br.wcabral.kotlin.android.githubcompose.di

import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepository
import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<GithubRepository> {
        GithubRepositoryImpl(
            githubApi = get()
        )
    }

}