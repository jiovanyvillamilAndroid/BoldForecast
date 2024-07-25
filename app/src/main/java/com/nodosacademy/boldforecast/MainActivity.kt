package com.nodosacademy.boldforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.nodosacademy.boldforecast.home.HomeScreenViewModel
import com.nodosacademy.boldforecast.ui.theme.BoldForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeScreenViewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        actionBar?.hide()
        setContent {
            BoldForecastTheme {
                val navController = rememberNavController()
                AppNavHost(
                    navController = navController,
                    homeScreenUIState = homeScreenViewModel.homeScreenUIState,
                    onHomeScreenEvent = { homeScreenViewModel.onScreenEvent(it) })
            }
        }
    }
}
