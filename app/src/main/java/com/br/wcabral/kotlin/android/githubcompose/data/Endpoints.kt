package com.br.wcabral.kotlin.android.githubcompose.data

object Endpoints {
    const val BASE_URL = "https://api.github.com/"

    const val GET_USERS = "users"
    const val GET_USER = "users/{userLogin}"
    const val GET_REPOS_BY_USER = "users/{userLogin}/repos"
}
