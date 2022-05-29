package com.br.wcabral.kotlin.android.githubcompose.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") val userId: String = "",
    @SerializedName("avatar_url") val avatarUrl: String = "",
    @SerializedName("html_url") val htmlUrl: String = "",
)

fun buildUserPreview() = User(
    userId = "wellingtoncabral",
    avatarUrl = "https://avatars.githubusercontent.com/u/24476557?v=4",
    htmlUrl = "https://github.com/wellingtoncabral",
)
