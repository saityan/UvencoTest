package saityan.misc.uvencotest.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import saityan.misc.uvencotest.R
import saityan.misc.uvencotest.viewmodel.TopBarViewModel

@Composable
fun TopBar(
    viewModel: TopBarViewModel = hiltViewModel()
) {
    val currentTime by viewModel.currentTime.collectAsState("")
    val randomNumber by viewModel.randomNumber.collectAsState(0.0f)

    BoxWithConstraints {
        val screenWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }

        val horizontalPadding = if (screenWidth < 400.dp) 8.dp else 16.dp
        val dividerHeight = if (screenWidth < 400.dp) 48.dp else 65.dp

        Column {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "RUNERO Touch",
                        modifier = Modifier.padding(6.dp),
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color(90, 64, 54)
                        )
                    )
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.union),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = currentTime,
                            modifier = Modifier.padding(horizontal = horizontalPadding),
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color(90, 64, 54)
                            )
                        )

                        VerticalDivider(
                            color = Color(90, 64, 54),
                            height = dividerHeight
                        )

                        Row(
                            modifier = Modifier.padding(horizontal = horizontalPadding),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = String.format("%.1f", randomNumber) + "°",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = Color(90, 64, 54)
                                )
                            )

                            Image(
                                painter = painterResource(id = R.drawable.temperature_label),
                                contentDescription = null,
                                modifier = Modifier.size(12.dp)
                            )
                        }

                        VerticalDivider(
                            color = Color(90, 64, 54),
                            height = dividerHeight
                        )

                        Row(
                            modifier = Modifier.padding(horizontal = horizontalPadding),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_ru),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )

                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                text = "RU",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = Color(90, 64, 54)
                                )
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                modifier = Modifier.wrapContentSize()
            )
            HorizontalDivider()
        }
    }
}

@Composable
fun VerticalDivider(color: Color = Color(90, 64, 54), height: Dp = 48.dp) {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(height)
            .background(color)
    )
}

@Composable
fun HorizontalDivider(color: Color = Color(90, 64, 54), width: Dp = 1.dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(width)
            .background(color)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}