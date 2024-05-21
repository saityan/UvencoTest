package saityan.misc.uvencotest.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import saityan.misc.uvencotest.view.TopBar

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Column {
        TopBar()
        SetupNavGraph(navController = navController)
    }
}