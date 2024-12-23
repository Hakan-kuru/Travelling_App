package com.example.Travelling_App.data.repositories

import com.example.Travelling_App.data.database.local.daos.AccommodationDao
import com.example.Travelling_App.data.database.local.entity.AccommodationEntity
import com.example.Travelling_App.domain.models.Accommodation

class AccommodationRepository(private val accommodationDao: AccommodationDao){
    suspend fun getAllAccommandation(): List<Accommodation> {
        return accommodationDao.getAllAccommandation().map { it.toDomainModel() }
    }
    suspend fun getAccommandationById(accomodationId: Int): Accommodation? {
        return accommodationDao.getAccommandationById(accomodationId)?.toDomainModel()
    }

    suspend fun insertAccommandation(accomodation: Accommodation) {
        accommodationDao.insertAccommandation(accomodation.toEntity())
    }
    suspend fun deleteAccommandationById(accomodationId: Int) {
        accommodationDao.deleteAccommandationById(accomodationId)
    }

    suspend fun deleteAllAccommandation() {
        accommodationDao.deleteAllAccommandation()
    }
    suspend fun getAccommandationByName(name: String): Accommodation? {
        return accommodationDao.getAccommandationByName(name)?.toDomainModel()
    }
    suspend fun getAccommandationByType(type: String): List<Accommodation> {
        return accommodationDao.getAccommandationByType(type).map{it.toDomainModel()}
    }

    suspend fun getAccommandationByDestinationId(destinationId: Int): List<Accommodation> {
        return accommodationDao.getAccommandationByDestinationId(destinationId).map { it.toDomainModel() }
    }
}
// Dönüşüm fonksiyonları
fun AccommodationEntity.toDomainModel() = Accommodation(accomodationId, destinationId, accomodationname, type, description)
fun Accommodation.toEntity() = AccommodationEntity(accomodationId, destinationId, accomodationname, type, description)