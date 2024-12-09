package com.example.Travelling_App.data.database.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accommodation_table")
class AccommodationEntity (
    @PrimaryKey val accomodationId: Int,
    val destinationId: Int,
    val accomodationname: String,
    val type: String,
    val description: String,
)