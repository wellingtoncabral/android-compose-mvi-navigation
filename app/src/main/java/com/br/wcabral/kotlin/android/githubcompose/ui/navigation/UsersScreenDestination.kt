package com.br.wcabral.kotlin.android.githubcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.UsersContract
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.UsersViewModel
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.composables.UsersScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun UsersScreenDestination(navController: NavController) {
    val viewModel = getViewModel<UsersViewModel>()
    UsersScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event ->  viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is UsersContract.Effect.Navigation.ToRepos) {
                navController.navigate(
                    route = "${Navigation.Routes.USERS}/${navigationEffect.userLogin}"
                )
            }
        }
    )
}
