package com.example.Travelling_App.domain.models

class Reminder(
    val reminderId: Int,
    val userId: Int,
    val destinationId: Int,
    //val activityId: Int,
    val reminderDate: String,
    val reminderNote: String
)