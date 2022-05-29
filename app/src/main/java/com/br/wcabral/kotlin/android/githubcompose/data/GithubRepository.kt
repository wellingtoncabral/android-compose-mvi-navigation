package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserDetail

interface GithubRepository {
    suspend fun getUsers(): Result<List<User>>
    suspend fun getUser(userId: String): Result<UserDetail?>
    suspend fun getRepos(userId: String): Result<List<Repo>>
}
