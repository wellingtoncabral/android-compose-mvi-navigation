package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.br.wcabral.kotlin.android.githubcompose.R
import com.br.wcabral.kotlin.android.githubcompose.ui.base.SIDE_EFFECTS_KEY
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
    val snackbarMessage = stringResource(R.string.users_screen_snackbar_loaded_message)

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is UsersContract.Effect.DataWasLoaded -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = snackbarMessage,
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
        if (state.isLoading) {
            Progress()
        } else {
            Column(modifier = Modifier.fillMaxSize()) {
                UsersList(users = state.users) { user ->
                    onEventSent(UsersContract.Event.UserSelection(user))
                }
            }
        }
    }
}
