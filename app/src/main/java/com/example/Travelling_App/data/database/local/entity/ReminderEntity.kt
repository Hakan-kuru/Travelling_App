package com.example.Travelling_App.data.database.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder_table")
class ReminderEntity (
    @PrimaryKey val reminderId: Int,
    val userId: Int,
    //val activityId: Int,
    val destinationId: Int,
    val reminderDate: String,
    val reminderNote: String
     // val reminderName: String,
)