package com.example.Travelling_App.data.database.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "destination_table")
class DestinationEntity(
    @PrimaryKey val destinationId: Int,
    val name: String,
    val country: String,
    val popularity: Int
)