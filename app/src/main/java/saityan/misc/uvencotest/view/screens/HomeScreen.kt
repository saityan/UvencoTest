package saityan.misc.uvencotest.view.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import saityan.misc.uvencotest.navigation.Screen
import saityan.misc.uvencotest.view.screens.home.CoffeeCupItem
import saityan.misc.uvencotest.viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val cups = viewModel.cups.collectAsState(initial = emptyList()).value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(5)
        ) {
            items(cups.size) { index ->
                val coffeeCup = cups[index]
                Box(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    CoffeeCupItem(
                        id = coffeeCup.id,
                        name = coffeeCup.name,
                        price = coffeeCup.price,
                        cupVariant = coffeeCup.cupVariant,
                        onClick = { cupId ->
                            navController.navigate(Screen.Edit.createRoute(cupId))
                        }
                    )
                }
            }
        }
    }
}