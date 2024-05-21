package saityan.misc.uvencotest.view.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import saityan.misc.uvencotest.R
import saityan.misc.uvencotest.model.CupVariant

@Composable
fun CoffeeCupItem(
    id: Int?,
    name: String,
    price: String,
    cupVariant: CupVariant,
    onClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 3.dp, vertical = 8.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(25, 17, 14),
                        Color(16, 9, 9)
                    )
                )
            )
            .clickable { id?.let { onClick(it) } }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val imageRes = when (cupVariant) {
                CupVariant.NORMAL -> R.drawable.normal_medium
                CupVariant.CREAM -> R.drawable.cream_medium
            }


            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium.copy(color = Color(196, 167, 155)),
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
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
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleMedium.copy(color = Color(247, 116, 22))
                )

                Text(
                    text = " Р",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color(247, 116, 22))
                )
            }
        }
    }
}