package saityan.misc.uvencotest.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import saityan.misc.uvencotest.model.CupVariant
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

@Composable
fun CoffeeCupDetails(
    name: String,
    onNameChange: (String) -> Unit,
    price: String,
    onPriceChange: (String) -> Unit,
    isFree: Boolean,
    onIsFreeChange: (Boolean) -> Unit,
    variant: CupVariant,
    onVariantChange: (CupVariant) -> Unit,
    onSave: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Name:", style = MaterialTheme.typography.titleMedium)
        BasicTextField(
            value = name,
            onValueChange = onNameChange,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Price:", style = MaterialTheme.typography.titleMedium)
        BasicTextField(
            value = price,
            onValueChange = onPriceChange,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(text = "Is Free:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.width(8.dp))
            IconToggleButton(
                checked = isFree,
                onCheckedChange = onIsFreeChange
            ) {
                Icon(
                    imageVector = if (isFree) Icons.Default.Check else Icons.Default.Close,
                    contentDescription = null
                )
            }
        }

        Text(text = "Variant:", style = MaterialTheme.typography.titleMedium)

        Button(
            onClick = onSave,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Save")
        }
    }
}