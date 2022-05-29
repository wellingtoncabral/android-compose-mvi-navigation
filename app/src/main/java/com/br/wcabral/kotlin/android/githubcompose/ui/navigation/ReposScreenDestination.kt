package com.br.wcabral.kotlin.android.githubcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos.ReposContract
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos.ReposViewModel
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos.composables.ReposScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ReposScreenDestination(UserId: String, navController: NavController) {
    val viewModel = getViewModel<ReposViewModel> { parametersOf(UserId) }
    ReposScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is ReposContract.Effect.Navigation.Back) {
                navController.popBackStack()
            }
        },
    )
}
