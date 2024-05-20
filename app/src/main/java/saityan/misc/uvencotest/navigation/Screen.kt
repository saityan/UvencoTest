package saityan.misc.uvencotest.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Edit : Screen("edit/{cupId}") {
        fun createRoute(cupId: Int) = "edit/$cupId"
    }
}
