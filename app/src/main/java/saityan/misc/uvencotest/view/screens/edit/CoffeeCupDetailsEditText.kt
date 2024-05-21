package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CoffeeCupDetailsEditText(
    text: String,
    onTextChanged: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(29, 20, 18),
                        Color(22, 14, 12),
                        Color(35, 25, 23)
                    )
                )
            )
    ) {
        BasicTextField(
            value = text,
            singleLine = true,
            onValueChange = onTextChanged,
            textStyle = MaterialTheme.typography.titleLarge.copy(
                color = Color(255, 242, 237),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_7_2013)
@Composable
fun CoffeeCupDetailsEditTextPreview() {
    CoffeeCupDetailsEditText(text = "Text", onTextChanged = {})
}