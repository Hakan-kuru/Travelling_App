package com.example.Travelling_App.data.repositories

import com.example.Travelling_App.data.database.local.daos.ActivityDao
import com.example.Travelling_App.data.database.local.entity.ActivityEntity
import com.example.Travelling_App.domain.models.Activity

class ActivityRepository(private val activityDao: ActivityDao) {

    suspend fun getAllActivities(): List<Activity> {
        return activityDao.getAllActivities().map { it.toDomainModel() }
    }

    suspend fun getActivityById(activityId: Int): Activity? {
        return activityDao.getActivityById(activityId)?.toDomainModel()
    }

    suspend fun insertActivity(activity: Activity) {
        activityDao.insertActivity(activity.toEntity())
    }

    suspend fun deleteActivityById(activityId: Int) {
        activityDao.deleteActivityById(activityId)
    }

    suspend fun getActivityByName(name: String): Activity? {
        return activityDao.getActivityByName(name)?.toDomainModel()
    }

    suspend fun getActivitiesByType(type: String): List<Activity> {
        return activityDao.getActivitiesByType(type).map { it.toDomainModel() }
    }

    suspend fun getActivitiesByDestinationId(destinationId: Int): List<Activity> {
        return activityDao.getActivitiesByDestinationId(destinationId).map { it.toDomainModel() }
    }

}
// Dönüşüm fonksiyonları
fun ActivityEntity.toDomainModel() = Activity( activityId, destinationId, activityname, type, description, image)
fun Activity.toEntity() = ActivityEntity(activityId, destinationId, activityName, type, description, image)