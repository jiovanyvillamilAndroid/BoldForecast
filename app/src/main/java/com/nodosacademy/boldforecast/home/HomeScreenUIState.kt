package com.nodosacademy.boldforecast.home

data class HomeScreenUIState(
    val state: State = State.EmptyState,
    val searchText: String = "",
)