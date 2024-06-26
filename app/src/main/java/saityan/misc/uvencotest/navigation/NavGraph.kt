package saityan.misc.uvencotest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import saityan.misc.uvencotest.view.screens.edit.EditScreen
import saityan.misc.uvencotest.view.screens.home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Edit.route + "/{cupId}",
            arguments = listOf(navArgument("cupId") { type = NavType.IntType })
        ) { backStackEntry ->
            val cupId = backStackEntry.arguments?.getInt("cupId") ?: -1
            EditScreen(cupId = cupId)
        }
    }
}