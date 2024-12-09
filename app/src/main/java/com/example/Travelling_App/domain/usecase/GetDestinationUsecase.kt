package com.example.Travelling_App.domain.usecase

import com.example.Travelling_App.data.database.repositories.DestinationRepository
import com.example.Travelling_App.domain.models.Destination

class GetDestinationUsecase(private val destinationRepository: DestinationRepository) {
    suspend fun getDestinationById(destinationId: Int): Destination? {
        return destinationRepository.getDestinationById(destinationId)
    }
    suspend fun insertDestination(destination: Destination) {
        destinationRepository.insertDestination(destination)
    }
    suspend fun deleteDestinationById(destinationId: Int) {
        destinationRepository.deleteDestinationById(destinationId)
    }
    suspend fun getDestinationByName(name: String): Destination? {
        return destinationRepository.getDestinationByName(name)
    }
    suspend fun getDestinationsByCountry(country: String): List<Destination> {
        return destinationRepository.getDestinationsByCountry(country)
    }

    suspend fun getDestinationsByPopularity(popularity: Int): List<Destination> {
        return destinationRepository.getDestinationsByPopularity(popularity)
    }
}