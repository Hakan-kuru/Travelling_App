package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.Travelling_App.domain.models.Activity
import com.example.Travelling_App.domain.usecase.ActivityUsecase

class ActivityViewModel(private val activityUsecase: ActivityUsecase) : ViewModel(){
    suspend fun getAllActivities(): List<Activity> {
        return activityUsecase.getAllActivities()
    }
    suspend fun getActivityById(activityId: Int): Activity? {
        return activityUsecase.getActivityById(activityId)
    }
    suspend fun insertActivity(activity: Activity) {
        activityUsecase.insertActivity(activity)
    }
    suspend fun deleteActivityById(activityId: Int) {
        activityUsecase.deleteActivityById(activityId)
    }
    suspend fun getActivityByName(name: String): Activity? {
        return activityUsecase.getActivityByName(name)
    }
    suspend fun getActivitiesByType(type: String): List<Activity> {
        return activityUsecase.getActivitiesByType(type)
    }
    suspend fun getActivitiesByDestinationId(destinationId: Int): List<Activity> {
        return activityUsecase.getActivitiesByDestinationId(destinationId)
    }

}