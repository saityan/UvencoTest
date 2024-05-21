package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
    onSave: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Name:",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color(196, 167, 155)),
                )

                BasicTextField(
                    value = name,
                    onValueChange = onNameChange,
                    textStyle = MaterialTheme.typography.titleLarge.copy(
                        color = Color(
                            255,
                            242,
                            237
                        )
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(29, 20, 18),
                                    Color(22, 14, 12),
                                    Color(35, 25, 23)
                                )
                            )
                        )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Price:",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color(196, 167, 155)),
                )

                BasicTextField(
                    value = price,
                    onValueChange = onPriceChange,
                    textStyle = MaterialTheme.typography.titleLarge.copy(
                        color = Color(
                            255,
                            242,
                            237
                        )
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(29, 20, 18),
                                    Color(22, 14, 12),
                                    Color(35, 25, 23)
                                )
                            )
                        )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "Is Free:",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color(
                                196,
                                167,
                                155
                            )
                        ),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconToggleButton(
                        checked = isFree,
                        onCheckedChange = onIsFreeChange
                    ) {
                        Icon(
                            imageVector = if (isFree) Icons.Default.Check else Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.cream_large),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .padding(4.dp)
                        .alpha(if (variant == CupVariant.CREAM) 1f else 0.3f)
                        .clickable { onVariantChange(CupVariant.CREAM) }
                )

                Box(
                    modifier = Modifier
                        .offset(y = 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.normal_large),
                        contentDescription = null,
                        modifier = Modifier
                            .size(300.dp)
                            .padding(4.dp)
                            .alpha(if (variant == CupVariant.NORMAL) 1f else 0.3f)
                            .clickable { onVariantChange(CupVariant.NORMAL) }
                    )
                }
            }
        }

        Button(
            onClick = onSave,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(247, 116, 22)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp)
        ) {
            Text(text = "Save")
        }
    }
}