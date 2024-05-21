package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import saityan.misc.uvencotest.R

@Composable
fun CoffeeDetailsSaveButton(
    areChangesPending: Boolean = false,
    onSave: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onSave,
            enabled = areChangesPending,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(247, 116, 22)
            ),
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.save_button_text))
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_7_2013)
@Composable
fun CoffeeCupDetailsSaveButtonPreview() {
    CoffeeDetailsSaveButton(onSave = {}, areChangesPending = true)
}