package com.example.Travelling_App.data.database.local.AppDarabase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.Travelling_App.data.database.local.daos.AccommodationDao
import com.example.Travelling_App.data.database.local.daos.ActivityDao
import com.example.Travelling_App.data.database.local.daos.DestinationDao
import com.example.Travelling_App.data.database.local.daos.ReminderDao
import com.example.Travelling_App.data.database.local.daos.UserDao
import com.example.Travelling_App.data.database.local.entity.AccommodationEntity
import com.example.Travelling_App.data.database.local.entity.ActivityEntity
import com.example.Travelling_App.data.database.local.entity.DestinationEntity
import com.example.Travelling_App.data.database.local.entity.ReminderEntity
import com.example.Travelling_App.data.database.local.entity.RestaurantEntity
import com.example.Travelling_App.data.database.local.entity.UserEntity
import com.example.Travelling_App.data.database.local.entity.WeatherEntity
import com.example.Travelling_App.presentation.viewmodel.WeatherViewModel
import org.junit.runner.manipulation.Ordering.Context

@Database(version = 1,
    entities = [
        UserEntity::class,
        DestinationEntity::class,
        ActivityEntity::class,
        AccommodationEntity::class,
        ReminderEntity::class,
        WeatherEntity::class,
        RestaurantEntity::class,
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun destinationDao(): DestinationDao
    abstract fun activityDao(): ActivityDao
    abstract fun accommodationDao(): AccommodationDao
    abstract fun reminderDao(): ReminderDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? =null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context/*????????????????*/,
                    AppDatabase::class.java,
                    "user_table"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}