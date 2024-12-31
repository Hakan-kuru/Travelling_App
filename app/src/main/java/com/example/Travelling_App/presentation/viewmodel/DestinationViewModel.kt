package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.Travelling_App.domain.models.Destination
import com.example.Travelling_App.domain.usecase.GetDestinationUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val getDestinationUsecase: GetDestinationUsecase
) : ViewModel() {

    suspend fun getDestinationById(destinationId: Int): Destination? {
        return getDestinationUsecase.getDestinationById(destinationId)
    }

    suspend fun insertDestination(destination: Destination) {
        getDestinationUsecase.insertDestination(destination)
    }

    suspend fun deleteDestinationById(destinationId: Int) {
        getDestinationUsecase.deleteDestinationById(destinationId)
    }

    suspend fun getDestinationByName(name: String): Destination? {
        return getDestinationUsecase.getDestinationByName(name)
    }

    suspend fun getDestinationsByCountry(country: String): List<Destination> {
        return getDestinationUsecase.getDestinationsByCountry(country)
    }

    suspend fun getDestinationsByPopularity(popularity: Int): List<Destination> {
        return getDestinationUsecase.getDestinationsByPopularity(popularity)
    }
}