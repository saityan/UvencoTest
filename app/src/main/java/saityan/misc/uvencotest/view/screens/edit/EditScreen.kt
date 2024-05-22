package saityan.misc.uvencotest.view.screens.edit

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.EntryPointAccessors
import saityan.misc.uvencotest.di.EditViewModelFactoryProvider
import saityan.misc.uvencotest.viewmodel.EditViewModel

@Composable
fun EditScreen(cupId: Int) {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        EditViewModelFactoryProvider::class.java
    ).editViewModelFactory()

    val viewModel: EditViewModel = viewModel(
        factory = EditViewModel.provideEditViewModelFactory(factory, cupId)
    )

    val cupState by viewModel.cup.collectAsState()

    cupState?.let { cup ->
        var name by rememberSaveable { mutableStateOf(cup.name) }
        var price by rememberSaveable { mutableStateOf(cup.price) }
        var isFree by rememberSaveable { mutableStateOf(cup.isFree) }
        var variant by rememberSaveable { mutableStateOf(cup.cupVariant) }

        val verticalScrollState = rememberScrollState()

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
                .background(Color.Black)
                .padding(25.dp)
        ) {
            CoffeeCupDetails(
                name = name,
                onNameChange = {
                    name = it
                    viewModel.updateCup(cup.copy(name = it))
                    viewModel.setChangesPending(true)
                },
                price = price,
                onPriceChange = {
                    price = it
                    viewModel.updateCup(cup.copy(price = it))
                    viewModel.setChangesPending(true)
                },
                isFree = isFree,
                onIsFreeChange = {
                    isFree = it
                    viewModel.updateCup(cup.copy(isFree = it))
                    viewModel.setChangesPending(true)
                },
                variant = variant,
                onVariantChange = {
                    variant = it
                    viewModel.updateCup(cup.copy(cupVariant = it))
                    viewModel.setChangesPending(true)
                },
                onSave = {
                    viewModel.saveCup()
                },
                areChangesPending = viewModel.areChangesPending.collectAsState().value
            )
        }
    }
}