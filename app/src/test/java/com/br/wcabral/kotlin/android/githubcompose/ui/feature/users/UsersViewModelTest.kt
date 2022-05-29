package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users

import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UsersViewModelTest {

    @MockK
    private lateinit var githubRepository: GithubRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `When getUsers, Then returns correct view state`() = runTest {
//        // Given
//        coEvery { githubRepository.getUsers() } returns Result.success(emptyList())
//
//        // When
//        val viewModel = UsersViewModel(githubRepository)
//
//        // Then
//        println(viewModel.viewState)
    }
}