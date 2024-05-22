package saityan.misc.uvencotest.view.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import saityan.misc.uvencotest.navigation.Screen
import saityan.misc.uvencotest.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val cups = viewModel.cups.collectAsState(initial = emptyList()).value
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val orientation = configuration.orientation

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val columns = when {
            screenWidth < 400.dp && orientation == Configuration.ORIENTATION_PORTRAIT -> 2
            screenWidth < 400.dp && orientation == Configuration.ORIENTATION_LANDSCAPE -> 4
            orientation == Configuration.ORIENTATION_PORTRAIT -> 3
            else -> 5
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.fillMaxSize()
        ) {
            items(cups.size) { index ->
                val coffeeCup = cups[index]
                Box(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
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