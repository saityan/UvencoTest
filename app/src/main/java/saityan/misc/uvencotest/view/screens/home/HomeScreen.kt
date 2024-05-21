package saityan.misc.uvencotest.view.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import saityan.misc.uvencotest.navigation.Screen
import saityan.misc.uvencotest.viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val cups = viewModel.cups.collectAsState(initial = emptyList()).value

    Scaffold(
        topBar = {
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(5)
                ) {
                    items(cups.size) { index ->
                        val coffeeCup = cups[index]
                        Box(
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            CoffeeCupItem(
                                id = coffeeCup.id,
                                name = coffeeCup.name,
                                price = coffeeCup.price,
                                cupVariant = coffeeCup.cupVariant,
                                isFree = coffeeCup.isFree,
                                onClick = { cupId ->
                                    navController.navigate(Screen.Edit.createRoute(cupId))
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}