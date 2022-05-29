package com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserDetail
import com.br.wcabral.kotlin.android.githubcompose.ui.base.ViewEvent
import com.br.wcabral.kotlin.android.githubcompose.ui.base.ViewSideEffect
import com.br.wcabral.kotlin.android.githubcompose.ui.base.ViewState

class ReposContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        object BackButtonClicked : Event()
    }

    data class State(
        val user: UserDetail?,
        val reposList: List<Repo>,
        val isUserLoading: Boolean,
        val isReposLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}
