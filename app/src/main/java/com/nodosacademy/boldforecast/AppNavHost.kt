package com.nodosacademy.boldforecast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nodosacademy.boldforecast.detail.DetailScreen
import com.nodosacademy.boldforecast.detail.data.DetailScreenUIState
import com.nodosacademy.boldforecast.home.HomeScreen
import com.nodosacademy.boldforecast.home.HomeScreenEvent
import com.nodosacademy.boldforecast.home.HomeScreenUIState

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
    homeScreenUIState: HomeScreenUIState,
    onHomeScreenEvent: (HomeScreenEvent) -> Unit,
    detailScreenUIState: DetailScreenUIState,
    fetchDetails: (String?, String?) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(homeScreenUIState = homeScreenUIState, onHomeScreenEvent = {
                when (it) {
                    is HomeScreenEvent.OnItemNavigation -> navController.navigate(NavigationItem.Detail.route + "/${it.lat}/${it.lon}")
                    is HomeScreenEvent.OnSearchElement -> onHomeScreenEvent(it)
                }
            })
        }

        composable(
            NavigationItem.Detail.route + "/{lat}/{lon}",
            arguments = listOf(
                navArgument("lat") { type = NavType.StringType },
                navArgument("lon") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.let {
                val lat = it.getString("lat")
                val lon = it.getString("lon")
                if (lat != null && lon != null) {
                    DetailScreen(
                        detailScreenUIState = detailScreenUIState,
                        fetchDetails = {
                            fetchDetails(lat, lon)
                        },
                    )
                }
            }
        }
    }
}

