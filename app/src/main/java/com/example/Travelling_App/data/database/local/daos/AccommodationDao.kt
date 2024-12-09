package com.example.Travelling_App.data.database.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.Travelling_App.data.database.local.entity.AccommodationEntity

@Dao
interface AccommodationDao{

    @Query("SELECT * FROM accommodation_table")
    suspend fun getAllAccommandation(): List<AccommodationEntity>

    @Query("SELECT * FROM accommodation_table WHERE accomodationId = :accomodationId")
    suspend fun getAccommandationById(accomodationId: Int): AccommodationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccommandation(accomodation: AccommodationEntity)

    @Query("DELETE FROM accommodation_table WHERE accomodationId = :accomodationId")
    suspend fun deleteAccommandationById(accomodationId: Int)

    @Query("DELETE FROM accommodation_table")
    suspend fun deleteAllAccommandation()

    @Query("SELECT * FROM accommodation_table WHERE accomodationname = :name")
    suspend fun getAccommandationByName(name: String): AccommodationEntity?

    @Query("SELECT * FROM accommodation_table WHERE type = :type")
    suspend fun getAccommandationByType(type: String): List<AccommodationEntity>

    @Query("SELECT * FROM accommodation_table WHERE destinationId = :destinationId")
    suspend fun getAccommandationByDestinationId(destinationId: Int): List<AccommodationEntity>

}