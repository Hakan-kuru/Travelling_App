package com.example.Travelling_App.domain.usecase

import androidx.lifecycle.ViewModel
import com.example.Travelling_App.data.repositories.ActivityRepository
import com.example.Travelling_App.domain.models.Activity

class ActivityUsecase(private val activityRepo: ActivityRepository) : ViewModel() {

    suspend fun getAllActivities(): List<Activity> {
        return activityRepo.getAllActivities().map { it }
    }

    suspend fun getActivityById(activityId: Int): Activity? {
        return activityRepo.getActivityById(activityId)
    }

    suspend fun insertActivity(activity: Activity) {
        activityRepo.insertActivity(activity)
    }

    suspend fun deleteActivityById(activityId: Int) {
        activityRepo.deleteActivityById(activityId)
    }

    suspend fun getActivityByName(name: String): Activity? {
        return activityRepo.getActivityByName(name)
    }

    suspend fun getActivitiesByType(type: String): List<Activity> {
        return activityRepo.getActivitiesByType(type)
    }

    suspend fun getActivitiesByDestinationId(destinationId: Int): List<Activity> {
        return activityRepo.getActivitiesByDestinationId(destinationId)
    }
}