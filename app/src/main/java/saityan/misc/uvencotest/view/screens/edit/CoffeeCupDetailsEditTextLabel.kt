package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import saityan.misc.uvencotest.R

@Composable
fun CoffeeCupDetailsEditTextLabel(
    id: Int
) {
    Text(
        text = stringResource(id = id),
        style = MaterialTheme.typography.titleMedium.copy(
            color = Color(196, 167, 155)
        ),
        modifier = Modifier.padding(vertical = 6.dp)
    )
}

@Preview(showBackground = true, device = Devices.NEXUS_7_2013)
@Composable
fun CoffeeCupDetailsEditTextLabelPreview() {
    CoffeeCupDetailsEditTextLabel(R.string.app_name)
}