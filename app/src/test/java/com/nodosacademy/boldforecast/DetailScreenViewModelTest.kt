package com.nodosacademy.boldforecast

import com.nodosacademy.boldforecast.detail.DetailScreenViewModel
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

class DetailScreenViewModelTest {
    private lateinit var detailScreenViewModel: DetailScreenViewModel
    private val repository = mockk<Repository>(relaxed = true)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        detailScreenViewModel = DetailScreenViewModel(repository)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `on fetch details should call repository get details function`() = runTest {
        //GIVEN
        val lat = "34.2"
        val lon = "12.0"
        //WHEN
        detailScreenViewModel.fetchLocationDetails(lat = lat, lon = lon)
        advanceUntilIdle()
        //THEN
        coVerify(exactly = 1) { repository.getForecast(lat.toDouble(), lon.toDouble()) }
    }
}