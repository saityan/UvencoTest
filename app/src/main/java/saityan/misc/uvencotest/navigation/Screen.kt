package saityan.misc.uvencotest.navigation

sealed class Screen(val route: String){
    object Home: Screen("home_screen")
    object Edit: Screen("edit_screen")
}