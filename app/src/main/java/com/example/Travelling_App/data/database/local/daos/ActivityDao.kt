package com.example.Travelling_App.data.database.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.Travelling_App.data.database.local.entity.ActivityEntity

@Dao
interface ActivityDao{

    @Query("SELECT * FROM activity_table")
    suspend fun getAllActivities(): List<ActivityEntity>

    @Query("SELECT * FROM activity_table WHERE activityId = :activityId")
    suspend fun getActivityById(activityId: Int): ActivityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: ActivityEntity)

    @Query("DELETE FROM activity_table WHERE activityId = :activityId")
    suspend fun deleteActivityById(activityId: Int)

    @Query("SELECT * FROM activity_table WHERE activityname = :name")
    suspend fun getActivityByName(name: String): ActivityEntity?

    @Query("SELECT * FROM activity_table WHERE type = :type")
    suspend fun getActivitiesByType(type: String): List<ActivityEntity>

    @Query("SELECT * FROM activity_table WHERE destinationId = :destinationId")
    suspend fun getActivitiesByDestinationId(destinationId: Int): List<ActivityEntity>
}