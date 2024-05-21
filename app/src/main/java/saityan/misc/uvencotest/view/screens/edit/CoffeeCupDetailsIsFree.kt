package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import saityan.misc.uvencotest.R

@Composable
fun CoffeeCupDetailsIsFree(
    isFree: Boolean,
    onIsFreeChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(
                width = 1.dp,
                color = Color(38, 26, 24),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp),
        ) {
            Text(
                text = stringResource(id = R.string.is_free_label),
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color(196, 167, 155)
                ),
            )

            IconToggleButton(
                checked = isFree,
                onCheckedChange = onIsFreeChange
            ) {
                Icon(
                    imageVector = if (isFree) Icons.Default.Check else Icons.Default.Close,
                    contentDescription = null,
                    tint = (if (isFree) {
                        Color(247, 116, 22)
                    } else {
                        Color(196, 167, 155)
                    })
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_7_2013)
@Composable
fun CoffeeCupDetailsIsFreePreview() {
    CoffeeCupDetailsIsFree(isFree = false, onIsFreeChange = {})
}