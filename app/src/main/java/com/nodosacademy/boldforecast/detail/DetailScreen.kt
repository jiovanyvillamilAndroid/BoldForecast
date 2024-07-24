package com.nodosacademy.boldforecast.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

@Composable
fun DetailScreen(modifier: Modifier) {
    val gradientColors = listOf(Color.Black, Color.Magenta, Color.Yellow)
    Column(
        modifier = modifier
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
                shadow = Shadow(Color.Black, offset = Offset(1.0f, 2.0f), blurRadius = 3f),
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "London",
            fontSize = 32.sp,
            color = Color.White
        )
        //AsyncImage(modifiermodel = "", contentDescription = null)

    }
}


@Preview
@Composable
fun Preview() {
    DetailScreen(modifier = Modifier.fillMaxSize())
}