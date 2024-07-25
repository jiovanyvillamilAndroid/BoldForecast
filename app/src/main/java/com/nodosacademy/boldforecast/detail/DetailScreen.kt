package com.nodosacademy.boldforecast.detail

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.nodosacademy.boldforecast.detail.data.DateDataUI
import com.nodosacademy.boldforecast.detail.data.HourDataUI

@Composable
fun DetailScreen(modifier: Modifier = Modifier, latArgument: String, lonArgument: String) {
    val gradientColors = listOf(Color.Black, Color.White, Color.Magenta, Color.Yellow)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color("#158ADC".toColorInt()))
            .padding(top = 42.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "London",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Clear lat:${latArgument} - lon:${lonArgument}",
            fontSize = 12.sp,
            color = Color.White
        )


        //----------------------------------------
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.size(75.dp),
                model = "https://cdn.weatherapi.com/weather/64x64/day/176.png",
                contentDescription = null
            )
            Text(
                modifier = Modifier,
                text = "20°",
                fontSize = 75.sp,
                color = Color.White
            )
        }
        //----------------------------------------

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Row {
                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Default.KeyboardArrowUp,
                    tint = Color.White,
                    contentDescription = null
                )
                Text(
                    text = "06:48",
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
                    text = "06:48",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

        //----------------------------------------
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White.copy(alpha = 0.3f))
                .padding(8.dp),
            text = "48-hour forecast",
            color = Color.White
        )

        val hourItems = arrayListOf(
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/day/356.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/day/356.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),
            HourDataUI(
                time = "13",
                tempC = 20.6,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/176.png"
            ),
            HourDataUI(
                time = "14",
                tempC = 20.4,
                conditionIconURL = "https://cdn.weatherapi.com/weather/64x64/night/299.png"
            ),

            )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White.copy(alpha = 0.3f))
                .padding(8.dp)
        ) {
            items(hourItems) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
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
        //---------------------------------------------------------------

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


        val dayItems = arrayListOf(
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
            DateDataUI(
                dayName = "Monday",
                conditionIcon = "https://cdn.weatherapi.com/weather/64x64/day/308.png",
                maxTemp = 20.2,
                minTemp = 12.1,
            ),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White.copy(alpha = 0.3f))
                .padding(8.dp),
        ) {
            items(dayItems) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .weight(1f),
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
}


@Preview
@Composable
fun Preview() {
    DetailScreen(modifier = Modifier.fillMaxSize(), latArgument = "", lonArgument = "")
}