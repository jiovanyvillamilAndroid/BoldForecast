package com.nodosacademy.boldforecast

enum class Screen {
    HOME,
    DETAIL,
}

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Detail : NavigationItem(Screen.DETAIL.name)
}