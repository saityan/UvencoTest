package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import saityan.misc.uvencotest.viewmodel.EditViewModel

@Composable
fun EditScreen(
    viewModel: EditViewModel = hiltViewModel(),
    cupId: Int
) {
    LaunchedEffect(cupId) {
        viewModel.loadCupById(cupId)
    }

    val cupState by viewModel.cup.collectAsState()

    cupState?.let { cup ->
        var name by rememberSaveable { mutableStateOf(cup.name) }
        var price by rememberSaveable { mutableStateOf(cup.price) }
        var isFree by rememberSaveable { mutableStateOf(cup.isFree) }
        var variant by rememberSaveable { mutableStateOf(cup.cupVariant) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            CoffeeCupDetails(
                name = name,
                onNameChange = {
                    name = it
                    viewModel.updateCup(cup.copy(name = it))
                },
                price = price,
                onPriceChange = {
                    price = it
                    viewModel.updateCup(cup.copy(price = it))
                },
                isFree = isFree,
                onIsFreeChange = {
                    isFree = it
                    viewModel.updateCup(cup.copy(isFree = it))
                },
                variant = variant,
                onVariantChange = {
                    variant = it
                    viewModel.updateCup(cup.copy(cupVariant = it))
                },
                onSave = { viewModel.saveCup() }
            )
        }
    }
}