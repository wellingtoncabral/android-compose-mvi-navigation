package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.github.com/"

interface GithubApi {

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{userLogin}")
    suspend fun getUser(@Path("userLogin") userId: String): UserDetail?

    @GET("users/{userLogin}/repos")
    suspend fun getRepos(@Path("userLogin") userId: String): List<Repo>

}