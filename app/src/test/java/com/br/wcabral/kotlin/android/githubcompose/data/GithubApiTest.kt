package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserDetail
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class GithubApiTest {

    private val mockWebService = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(mockWebService.url("/"))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(GithubApi::class.java)

    @After
    fun tearDown() {
        mockWebService.shutdown()
    }

    @Test
    fun `Given 200 response When fetching users Then returns users correctly`() {
        // Given
        mockWebService.enqueueResponse(
            fileName = "users.json",
            code = 200
        )
        val expected = listOf(
            User(
                userId = "mojombo",
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                htmlUrl = "https://github.com/mojombo",
            ),
            User(
                userId = "defunkt",
                avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
                htmlUrl = "https://github.com/defunkt",
            ),
            User(
                userId = "pjhyett",
                avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4",
                htmlUrl = "https://github.com/pjhyett",
            ),
        )

        // When
        val actual = runBlocking { api.getUsers() }

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `Given 200 response When fetching user Then returns user correctly`() {
        // Given
        mockWebService.enqueueResponse(
            fileName = "user-detail.json",
            code = 200
        )
        val expected = UserDetail(
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            htmlUrl = "https://github.com/mojombo",
            name = "Tom Preston-Werner",
            location = "San Francisco",
            blogUrl = "http://tom.preston-werner.com",
            publicRepos = 64,
            followers = 22991,
            following = 11,
        )

        // When
        val actual = runBlocking { api.getUser("mojombo") }

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `Given 200 response When fetching repos Then returns repos correctly`() {
        // Given
        mockWebService.enqueueResponse(
            fileName = "repos.json",
            code = 200
        )

        val expected = listOf(
            Repo(
                id = 26899533,
                name = "30daysoflaptops.github.io",
                description = null,
                watchersCount = 7,
                forksCount = 2,
                stargazersCount = 7,
                language = "CSS",
                htmlUrl = "https://github.com/mojombo/30daysoflaptops.github.io",
            ),
            Repo(
                id = 17358646,
                name = "asteroids",
                description = "Destroy your Atom editor, Asteroids style!",
                watchersCount = 93,
                forksCount = 13,
                stargazersCount = 93,
                language = "JavaScript",
                htmlUrl = "https://github.com/mojombo/asteroids",
            ),
            Repo(
                id = 29941343,
                name = "benbalter.github.com",
                description = "The personal website of Ben Balter. Built using Jekyll and GitHub Pages. See humans.txt for more infos.",
                watchersCount = 5,
                forksCount = 7,
                stargazersCount = 5,
                language = "CSS",
                htmlUrl = "https://github.com/mojombo/benbalter.github.com",
            ),
        )

        // When
        val actual = runBlocking { api.getRepos("mojombo") }

        // Then
        assertEquals(expected, actual)
    }
}