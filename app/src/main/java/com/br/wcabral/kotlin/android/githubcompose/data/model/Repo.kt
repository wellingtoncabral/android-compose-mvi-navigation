package com.br.wcabral.kotlin.android.githubcompose.data.model

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id") val id: Long = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("description") val description: String? = null,
    @SerializedName("watchers_count") val watchersCount: Int = 0,
    @SerializedName("forks_count") val forksCount: Int = 0,
    @SerializedName("stargazers_count") val stargazersCount: Int = 0,
    @SerializedName("language") val language: String? = null,
    @SerializedName("html_url") val htmlUrl: String = "",
)

object RepoPreview {
    val repo: Repo
        get() = Repo(
            name = "GithubApi + Compose + MVI",
            description = "Sample project created using Jetpack compose + MVI",
            watchersCount = 100,
            forksCount = 123,
            stargazersCount = 90,
            language = "Kotlin"
        )
}