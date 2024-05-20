package saityan.misc.uvencotest.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.CupVariant
import saityan.misc.uvencotest.navigation.Screen
import saityan.misc.uvencotest.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val cups = listOf(CoffeeCup(1, "Cool Cup", "100", false, CupVariant.NORMAL))

    LazyColumn {
        itemsIndexed(cups) { index, coffeeCup ->
            Text(coffeeCup.name, modifier = Modifier.clickable {
                navController.navigate(Screen.Edit.route)
            })
        }
    }
}