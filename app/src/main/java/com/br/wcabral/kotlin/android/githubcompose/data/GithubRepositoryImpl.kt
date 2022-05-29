package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubRepositoryImpl(
    private val githubApi: GithubApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
): GithubRepository {

    override suspend fun getUsers(): Result<List<User>> = makeApiCall(dispatcher) {
        githubApi.getUsers()
    }

    override suspend fun getUser(userId: String): Result<UserDetail?> = makeApiCall(dispatcher) {
        githubApi.getUser(userId)
    }

    override suspend fun getRepos(userId: String): Result<List<Repo>> = makeApiCall(dispatcher) {
        githubApi.getRepos(userId)
    }

}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}
