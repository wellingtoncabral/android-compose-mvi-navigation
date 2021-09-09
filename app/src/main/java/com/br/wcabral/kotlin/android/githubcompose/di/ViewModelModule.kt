package com.br.wcabral.kotlin.android.githubcompose.di

import com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos.ReposViewModel
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UsersViewModel(githubRepository = get())
    }

    viewModel { parameters ->
        ReposViewModel(
            userLogin = parameters.get(),
            githubRepository = get()
        )
    }
}
