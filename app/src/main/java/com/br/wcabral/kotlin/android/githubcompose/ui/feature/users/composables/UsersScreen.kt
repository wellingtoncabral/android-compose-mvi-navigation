package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.composables

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.br.wcabral.kotlin.android.githubcompose.R
import com.br.wcabral.kotlin.android.githubcompose.data.model.buildUserPreview
import com.br.wcabral.kotlin.android.githubcompose.ui.base.SIDE_EFFECTS_KEY
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.common.NetworkError
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.common.Progress
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.UsersContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun UsersScreen(
    state: UsersContract.State,
    effectFlow: Flow<UsersContract.Effect>?,
    onEventSent: (event: UsersContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: UsersContract.Effect.Navigation) -> Unit
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val snackBarMessage = stringResource(R.string.users_screen_snackbar_loaded_message)

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is UsersContract.Effect.DataWasLoaded -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = snackBarMessage,
                        duration = SnackbarDuration.Short
                    )
                }
                is UsersContract.Effect.Navigation.ToRepos -> onNavigationRequested(effect)
            }
        }?.collect()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { UsersTopBar() }
    ) {
        when {
            state.isLoading -> Progress()
            state.isError -> NetworkError { onEventSent(UsersContract.Event.Retry) }
            else -> UsersList(users = state.users) { onEventSent(UsersContract.Event.UserSelection(it)) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersScreenSuccessPreview() {
    val users = List(3) { buildUserPreview() }
    UsersScreen(
        state = UsersContract.State(
            users = users,
            isLoading = false,
            isError = false,
        ),
        effectFlow = null,
        onEventSent = {},
        onNavigationRequested = {},
    )
}

@Preview(showBackground = true)
@Composable
fun UsersScreenErrorPreview() {
    UsersScreen(
        state = UsersContract.State(
            users = emptyList(),
            isLoading = false,
            isError = true,
        ),
        effectFlow = null,
        onEventSent = {},
        onNavigationRequested = {},
    )
}
