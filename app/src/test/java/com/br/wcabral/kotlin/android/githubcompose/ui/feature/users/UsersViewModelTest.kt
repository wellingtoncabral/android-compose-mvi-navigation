package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users

import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import com.br.wcabral.kotlin.android.githubcompose.MainCoroutineRule
import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepository
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@DelicateCoroutinesApi
@OptIn(ExperimentalCoroutinesApi::class)
class UsersViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val githubRepository = mockk<GithubRepository>()

    @Test
    fun `When view model initialized then should emit initial view state first`() = runTest {
        // Given
        val expectedInitialViewState = UsersContract.State(
            users = emptyList(),
            isLoading = true,
            isError = false
        )

        // When
        val viewModel = UsersViewModel(githubRepository)

        // Then
        assertEquals(expectedInitialViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getUsers called then should emit a view state`() = runTest {
        // Given
        val users = listOf(User(userId = "wcabral"))
        val expectedViewState = UsersContract.State(
            users = users,
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getUsers() } returns Result.success(users)

        // When
        val viewModel = UsersViewModel(githubRepository)

        // Then
        assertEquals(expectedViewState, viewModel.viewState.value)
    }

    @Test
    fun `When `() = runTest {

        // Given
        val users = listOf(User(userId = "wcabral"))
        val expectedViewState = UsersContract.State(
            users = users,
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getUsers() } returns Result.success(users)

        // When
        val snapshot = Snapshot.takeMutableSnapshot(
//            readObserver = {
//                println(it)
//            },
            writeObserver = {
                println(it)
            }
        )

        snapshot.enter {
            val viewModel = UsersViewModel(githubRepository)

            // Then
            assertEquals(expectedViewState, viewModel.viewState.value)
        }

        snapshot.apply()
    }

}