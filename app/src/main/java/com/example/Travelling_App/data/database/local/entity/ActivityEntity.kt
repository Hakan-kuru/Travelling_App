package com.example.Travelling_App.data.database.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_table")
class ActivityEntity(
    @PrimaryKey val activityId: Int,
    val destinationId: Int,
    val activityname: String,
    val type: String,
    val description: String,
    val image: String
)