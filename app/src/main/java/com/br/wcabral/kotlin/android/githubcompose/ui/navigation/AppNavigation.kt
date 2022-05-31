package com.br.wcabral.kotlin.android.githubcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.br.wcabral.kotlin.android.githubcompose.ui.navigation.Navigation.Args.USER_ID

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.USERS
    ) {
        composable(
            route = Navigation.Routes.USERS
        ) {
            UsersScreenDestination(navController)
        }

        composable(
            route = Navigation.Routes.REPOS,
            arguments = listOf(navArgument(name = USER_ID) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val userId = requireNotNull(backStackEntry.arguments?.getString(USER_ID)) { "User id is required as an argument" }
            ReposScreenDestination(
                UserId = userId,
                navController = navController
            )
        }
    }
}

object Navigation {

    object Args {
        const val USER_ID = "user_id"
    }

    object Routes {
        const val USERS = "users"
        const val REPOS = "$USERS/{$USER_ID}"
    }

}

fun NavController.navigateToRepos(userId: String) {
    navigate(route = "${Navigation.Routes.USERS}/$userId")
}
