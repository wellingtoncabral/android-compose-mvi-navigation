package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users

import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UsersViewModelTest {

    private val githubRepository = mockk<GithubRepository>()

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