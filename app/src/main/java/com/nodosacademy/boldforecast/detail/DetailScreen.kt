package com.nodosacademy.boldforecast.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.nodosacademy.boldforecast.detail.data.DayDataUI
import com.nodosacademy.boldforecast.detail.data.DetailScreenUIState
import com.nodosacademy.boldforecast.detail.data.HourDataUI

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailScreenUIState: DetailScreenUIState,
    fetchDetails: () -> Unit
) {
    LaunchedEffect(true) {
        fetchDetails()
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color("#158ADC".toColorInt()))
            .padding(top = 42.dp)
    ) {


        Header(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            detailScreenUIState.cityName,
            detailScreenUIState.country
        )

        MainTemp(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            detailScreenUIState.currentConditionIconURL,
            detailScreenUIState.currentTemp
        )

        MaxMin(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            detailScreenUIState.maxTemp,
            detailScreenUIState.minTemp
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White.copy(alpha = 0.3f))
                .padding(8.dp),
            text = "24-hour forecast",
            color = Color.White
        )

        HoursForecast(hoursForecast = detailScreenUIState.hoursForecast)

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White.copy(alpha = 0.3f))
                .padding(8.dp),
            text = "10-day forecast",
            color = Color.White
        )
        NextDaysForecast(daysDataList = detailScreenUIState.daysForecastDataList)
    }
}

@Composable
fun NextDaysForecast(modifier: Modifier = Modifier, daysDataList: List<DayDataUI>) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.3f))
            .padding(8.dp),
    ) {
        items(daysDataList) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = it.dayName,
                    color = Color.White
                )
                AsyncImage(
                    modifier = Modifier.size(30.dp),
                    model = it.conditionIcon,
                    contentDescription = null
                )
                Row {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                    Text(text = "${it.minTemp}º", color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null
                    )
                    Text(text = "${it.maxTemp}º", color = Color.White)
                }
            }
            HorizontalDivider()
        }
    }
}

@Composable
fun HoursForecast(modifier: Modifier = Modifier, hoursForecast: List<HourDataUI>) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.3f))
            .padding(8.dp)
    ) {
        items(hoursForecast) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = it.time,
                    color = Color.White
                )
                AsyncImage(
                    modifier = Modifier.size(30.dp),
                    model = it.conditionIconURL,
                    contentDescription = null
                )
                Text(
                    text = "${it.tempC}º",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}

@Composable
fun MaxMin(modifier: Modifier, maxTemp: Double, minTemp: Double) {
    Row(modifier = modifier) {
        Row {
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Default.KeyboardArrowUp,
                tint = Color.White,
                contentDescription = null
            )
            Text(
                text = "${maxTemp}°",
                fontSize = 12.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.width(30.dp))
        Row {
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Default.KeyboardArrowDown,
                tint = Color.White,
                contentDescription = null
            )
            Text(
                text = "${minTemp}°",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun MainTemp(modifier: Modifier, currentConditionIconURL: String, currentTemp: Double) {
    Row(
        modifier = modifier
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.size(75.dp),
            model = currentConditionIconURL,
            contentDescription = null
        )
        Text(
            modifier = Modifier,
            text = "${currentTemp}°",
            fontSize = 75.sp,
            color = Color.White
        )
    }
}

@Composable
fun Header(modifier: Modifier, cityName: String, country: String) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = cityName,
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = country,
            fontSize = 12.sp,
            color = Color.White
        )
    }

}