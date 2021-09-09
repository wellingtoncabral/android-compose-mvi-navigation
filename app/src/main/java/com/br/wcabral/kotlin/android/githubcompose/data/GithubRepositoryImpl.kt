package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User

class GithubRepositoryImpl(private val githubApi: GithubApi): GithubRepository {

    override suspend fun getUsers(): List<User> = githubApi.getUsers()

    override suspend fun getUser(userLogin: String): User = githubApi.getUser(userLogin)

    override suspend fun getRepos(userLogin: String): List<Repo> = githubApi.getRepos(userLogin)

}
