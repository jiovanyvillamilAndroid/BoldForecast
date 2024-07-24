package com.nodosacademy.boldforecast.home

sealed class HomeScreenEvent {
    data class OnSearchElement(val elementText: String) : HomeScreenEvent()
    data class OnItemNavigation(val lat: Double, val lon: Double) : HomeScreenEvent()
}