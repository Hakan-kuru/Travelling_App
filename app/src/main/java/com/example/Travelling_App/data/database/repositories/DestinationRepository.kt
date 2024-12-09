package com.example.Travelling_App.data.database.repositories

import com.example.Travelling_App.data.database.local.daos.DestinationDao
import com.example.Travelling_App.data.database.local.entity.DestinationEntity
import com.example.Travelling_App.domain.models.Destination

class DestinationRepository(private val destinationDao: DestinationDao) {

    suspend fun getDestinationById(destinationId: Int): Destination? {
        return destinationDao.getDestinationById(destinationId)?.toDomainModel()
    }
    suspend fun insertDestination(destination: Destination) {
        destinationDao.insertDestination(destination.toEntity())
    }

    suspend fun deleteDestinationById(destinationId: Int) {
        destinationDao.deleteDestinationById(destinationId)
    }

    suspend fun getDestinationByName(name: String): Destination? {
        return destinationDao.getDestinationByName(name)?.toDomainModel()
    }

    suspend fun getDestinationsByCountry(country: String): List<Destination> {
        return destinationDao.getDestinationsByCountry(country).map { it.toDomainModel() }
    }

    suspend fun getDestinationsByPopularity(popularity: Int): List<Destination> {
        return destinationDao.getDestinationsByPopularity(popularity).map { it.toDomainModel() }
    }
}
// Dönüşüm fonksiyonları
fun DestinationEntity.toDomainModel() = Destination( destinationId, name, country, popularity)
fun Destination.toEntity() = DestinationEntity( destinationId, name, country, popularity)
