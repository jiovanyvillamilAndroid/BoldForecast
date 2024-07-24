package com.nodosacademy.boldforecast.home

sealed class State {
    data class WithItems(val foundItems: List<LocationItem>) : State()
    data object EmptyState : State()
    data object Searching : State()
}