package saityan.misc.uvencotest.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.viewmodel.MainViewModel

@Composable
fun EditScreen(
    viewModel: MainViewModel = hiltViewModel(),
    cupId: Int
) {
    val cup = viewModel.getCupById(cupId).collectAsState(initial = null).value

    cup?.let {
        CoffeeCupDetails(cup = cup)
    }
}

@Composable
fun CoffeeCupDetails(cup: CoffeeCup) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Name: ${cup.name}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Price: ${cup.price}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Is Free: ${cup.isFree}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Variant: ${cup.cupVariant}", style = MaterialTheme.typography.bodySmall)
    }
}