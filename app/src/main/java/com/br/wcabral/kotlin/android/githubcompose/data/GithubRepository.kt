package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User

interface GithubRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUser(userLogin: String): User
    suspend fun getRepos(userLogin: String): List<Repo>
}
