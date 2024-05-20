package saityan.misc.uvencotest.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import saityan.misc.uvencotest.navigation.Screen
import saityan.misc.uvencotest.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val cups = viewModel.cups.collectAsState(initial = emptyList()).value

    LazyColumn {
        itemsIndexed(cups) { index, coffeeCup ->
            Text(coffeeCup.name, modifier = Modifier.clickable {
                navController.navigate(Screen.Edit.route)
            })
        }
    }
}
