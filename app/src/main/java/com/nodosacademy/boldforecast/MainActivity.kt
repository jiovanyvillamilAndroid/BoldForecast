package com.nodosacademy.boldforecast

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.nodosacademy.boldforecast.home.HomeScreen
import com.nodosacademy.boldforecast.home.HomeScreenUIState
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
                    HomeScreen(
                        homeScreenUIState = homeScreenViewModel.homeScreenUIState,
                        onHomeScreenEvent = { homeScreenViewModel.onScreenEvent(it) })
            }
        }
    }
}
