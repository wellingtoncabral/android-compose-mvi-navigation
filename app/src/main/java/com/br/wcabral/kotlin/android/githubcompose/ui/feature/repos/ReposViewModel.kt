package com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos

import androidx.lifecycle.viewModelScope
import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepository
import com.br.wcabral.kotlin.android.githubcompose.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ReposViewModel(
    private val userLogin: String,
    private val githubRepository: GithubRepository
) : BaseViewModel<ReposContract.Event, ReposContract.State, ReposContract.Effect>() {

    init {
        viewModelScope.launch {
            getUser(userLogin)
            getRepos()
        }
    }

    override fun setInitialState() = ReposContract.State(
        user = null,
        reposList = emptyList(),
        isUserLoading = true,
        isReposLoading = true
    )

    override fun handleEvents(event: ReposContract.Event) {
        when (event) {
            ReposContract.Event.BackButtonClicked -> {
                setEffect {
                    ReposContract.Effect.Navigation.Back
                }
            }
        }
    }

    private suspend fun getUser(userLogin: String) {
        val user = githubRepository.getUser(userLogin)
        setState {
            copy(user = user, isUserLoading = false)
        }
    }

    private suspend fun getRepos() {
        val repos = githubRepository.getRepos(userLogin)
        setState {
            copy(reposList = repos, isReposLoading = false)
        }
    }

}