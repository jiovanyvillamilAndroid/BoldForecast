package com.nodosacademy.boldforecast.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nodosacademy.boldforecast.R


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeScreenUIState: HomeScreenUIState,
    onHomeScreenEvent: (HomeScreenEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        SearchBar(searchText = homeScreenUIState.searchText, onValueChange = {
            onHomeScreenEvent(HomeScreenEvent.OnSearchElement(it))
        })
        when (homeScreenUIState.state) {
            State.EmptyState -> {
                EmptyStateAnimation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )
            }

            State.Searching -> {
                LoadingAnimation(modifier = Modifier.fillMaxSize())
            }

            is State.WithItems -> {
                val foundItems = homeScreenUIState.state.foundItems
                if (foundItems.isNotEmpty()) {
                    LocationList(
                        locationItemList = foundItems,
                        onItemNavigation = {
                            onHomeScreenEvent(it)
                        })
                } else {
                    NoItemsAnimation()
                }
            }
        }
    }
}

@Composable
fun EmptyStateAnimation(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.empty_state_animation
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            modifier = Modifier.padding(36.dp),
            text = "Bienvenido! \nBusca una ubicación para saber tu pronóstico del clima",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        LottieAnimation(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize(1f),
            composition = preloaderLottieComposition,
            progress = preloaderProgress,
        )
    }

}

@Composable
fun SearchBar(modifier: Modifier = Modifier, searchText: String, onValueChange: (String) -> Unit) {
    TextField(label = {
        Text(text = "Ingresa el nombre de la ubicación")
    }, modifier = modifier.fillMaxWidth(), value = searchText, onValueChange = {
        onValueChange(it)
    })
}

@Composable
fun LocationList(
    modifier: Modifier = Modifier,
    locationItemList: List<LocationItem>,
    onItemNavigation: (HomeScreenEvent.OnItemNavigation) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(locationItemList) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onItemNavigation(HomeScreenEvent.OnItemNavigation(it.lat, it.lon))
                    },
                fontSize = 18.sp,
                text = "${it.name} - ${it.country}"
            )
        }
    }
}


@Composable
fun NoItemsAnimation(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.not_found_items_animation
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}

@Composable
fun LoadingAnimation(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.finding_location_animation
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}