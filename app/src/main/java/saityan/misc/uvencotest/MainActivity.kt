package saityan.misc.uvencotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import saityan.misc.uvencotest.navigation.MainScreen
import saityan.misc.uvencotest.ui.theme.UvencoTestTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            UvencoTestTheme {
                MainScreen()
            }
        }
    }
}