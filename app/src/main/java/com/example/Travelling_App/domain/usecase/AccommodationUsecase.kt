package com.example.Travelling_App.domain.usecase

import com.example.Travelling_App.data.database.repositories.AccommodationRepository
import com.example.Travelling_App.domain.models.Accommodation

class AccommodationUsecase(private val accommodationRepository: AccommodationRepository) {

    suspend fun getAllAccommandation(): List<Accommodation> {
        return accommodationRepository.getAllAccommandation()
    }

    suspend fun getAccommandationById(accomodationId: Int): Accommodation? {
        return accommodationRepository.getAccommandationById(accomodationId)
    }

    suspend fun insertAccommandation(accomodation: Accommodation) {
        accommodationRepository.insertAccommandation(accomodation)
    }

    suspend fun deleteAccommandationById(accomodationId: Int) {
        accommodationRepository.deleteAccommandationById(accomodationId)
    }

    suspend fun deleteAllAccommandation() {
        accommodationRepository.deleteAllAccommandation()
    }

    suspend fun getAccommandationByName(name: String): Accommodation? {
        return accommodationRepository.getAccommandationByName(name)
    }

    suspend fun getAccommandationByType(type: String): List<Accommodation> {
        return accommodationRepository.getAccommandationByType(type)
    }

    suspend fun getAccommandationByDestinationId(destinationId: Int): List<Accommodation> {
        return accommodationRepository.getAccommandationByDestinationId(destinationId)
    }
}