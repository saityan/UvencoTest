package saityan.misc.uvencotest.view.screens.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import saityan.misc.uvencotest.R
import saityan.misc.uvencotest.model.CupVariant

@Composable
fun CoffeeCupDetailsCupVariants(
    variant: CupVariant,
    onVariantChange: (CupVariant) -> Unit
) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.cream_large),
            contentDescription = null,
            modifier = Modifier
                .size(175.dp)
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
                    .size(175.dp)
                    .padding(4.dp)
                    .alpha(if (variant == CupVariant.NORMAL) 1f else 0.3f)
                    .clickable { onVariantChange(CupVariant.NORMAL) }
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_7_2013)
@Composable
fun CoffeeCupDetailsCupVariantsPreview() {
    CoffeeCupDetailsCupVariants(variant = CupVariant.NORMAL, onVariantChange = {})
}