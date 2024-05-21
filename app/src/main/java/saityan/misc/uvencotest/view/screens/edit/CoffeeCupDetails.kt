package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import saityan.misc.uvencotest.R
import saityan.misc.uvencotest.model.CupVariant

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
    onSave: () -> Unit,
    areChangesPending: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CoffeeCupDetailsEditTextLabel(id = R.string.name_label)
                CoffeeCupDetailsEditText(text = name, onTextChanged = onNameChange)
                Spacer(modifier = Modifier.height(16.dp))
                CoffeeCupDetailsEditTextLabel(id = R.string.price_label)
                CoffeeCupDetailsEditPrice(price = price, onTextChanged = onPriceChange)
                Spacer(modifier = Modifier.height(16.dp))
                CoffeeCupDetailsIsFree(isFree = isFree, onIsFreeChange = onIsFreeChange)
            }

            Spacer(modifier = Modifier.width(16.dp))

            CoffeeCupDetailsCupVariants(variant = variant, onVariantChange = onVariantChange)
        }

        Spacer(modifier = Modifier.height(16.dp))

        CoffeeDetailsSaveButton(areChangesPending = areChangesPending, onSave = onSave)
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_7_2013)
@Composable
fun CoffeeCupDetailsPreview() {
    CoffeeCupDetails(
        name = "Амаретто",
        onNameChange = {},
        price = "150",
        onPriceChange = {},
        isFree = false,
        onIsFreeChange = {},
        variant = CupVariant.NORMAL,
        onVariantChange = {},
        onSave = {},
        areChangesPending = true
    )
}