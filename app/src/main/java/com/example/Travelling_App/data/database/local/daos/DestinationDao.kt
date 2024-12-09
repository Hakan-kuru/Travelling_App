package com.example.Travelling_App.data.database.local.daos

import androidx.room.Insert
import androidx.room.Query
import com.example.Travelling_App.data.database.local.entity.DestinationEntity
import androidx.room.OnConflictStrategy

interface DestinationDao {
    @Query("SELECT * FROM destination_table")
    suspend fun getAllDestinations(): List<DestinationEntity>

    @Query("SELECT * FROM destination_table WHERE destinationId = :destinationId")
    suspend fun getDestinationById(destinationId: Int): DestinationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: DestinationEntity)

    @Query("DELETE FROM destination_table WHERE destinationId = :destinationId")
    suspend fun deleteDestinationById(destinationId: Int)

    @Query("SELECT * FROM destination_table WHERE name = :name")
    suspend fun getDestinationByName(name: String): DestinationEntity?

    @Query("SELECT * FROM destination_table WHERE country = :country")
    suspend fun getDestinationsByCountry(country: String): List<DestinationEntity>


    @Query("SELECT * FROM destination_table WHERE popularity = :popularity")
    suspend fun getDestinationsByPopularity(popularity: Int): List<DestinationEntity>


}