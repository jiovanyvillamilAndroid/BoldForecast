package com.nodosacademy.boldforecast

import com.nodosacademy.boldforecast.home.HomeScreenEvent
import com.nodosacademy.boldforecast.home.HomeScreenViewModel
import com.nodosacademy.boldforecast.network.Repository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class HomeScreenViewModelTest {

    private lateinit var homeScreenViewModel: HomeScreenViewModel
    private val repository = mockk<Repository>(relaxed = true)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        homeScreenViewModel = HomeScreenViewModel(repository)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `onSearch element event should call repository search function`() = runTest {
        //GIVEN
        val testText = "Mocoa"
        val onSearchEvent = HomeScreenEvent.OnSearchElement(testText)
        //WHEN
        homeScreenViewModel.onScreenEvent(onSearchEvent)
        advanceUntilIdle()
        //THEN
        coVerify(exactly = 1) { repository.searchLocation(testText) }
    }
}